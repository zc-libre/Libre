package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.*;
import com.libre.boot.exception.BusinessException;
import com.libre.framework.blog.mapper.ArticleMapper;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.ArticleTag;
import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.Tag;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.dto.ArticleDTO;
import com.libre.framework.blog.pojo.dto.CategoryCriteria;
import com.libre.framework.blog.pojo.dto.TagCriteria;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.framework.blog.service.ArticleService;
import com.libre.framework.blog.service.ArticleTagService;
import com.libre.framework.blog.service.CategoryService;
import com.libre.framework.blog.service.TagService;
import com.libre.framework.blog.service.mapstruct.ArticleMapping;
import com.libre.mybatis.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

	private final ArticleTagService articleTagService;

	private final CategoryService categoryService;

	private final TagService tagService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void add(ArticleDTO articleDTO) {
		ArticleMapping mapping = ArticleMapping.INSTANCE;
		Article article = mapping.sourceToTarget(articleDTO);
		List<Long> tagIds = articleDTO.getTagIds();
		Long categoryId = articleDTO.getCategoryId();
		Category category = categoryService.getById(categoryId);
		if (Objects.isNull(category)) {
			throw new BusinessException("类型不存在：" + categoryId);
		}
		List<Tag> tags = tagService.listByIds(tagIds);
		if (CollectionUtils.isEmpty(tags)) {
			throw new BusinessException("标签不存在");
		}
		this.saveOrUpdate(article);
		List<ArticleTag> articleTagList = Lists.newArrayList();
		for (Tag tag : tags) {
			ArticleTag articleTag = new ArticleTag();
			articleTag.setTagId(tag.getId());
			articleTag.setArticleId(article.getId());
			articleTagList.add(articleTag);
		}
		articleTagService.deleteByArticleIds(ImmutableList.of(article.getId()));
		articleTagService.saveBatch(articleTagList);
	}

	@Override
	public void edit(ArticleDTO articleDTO) {
		ArticleMapping mapping = ArticleMapping.INSTANCE;
		Article article = mapping.sourceToTarget(articleDTO);
		this.updateById(article);
	}

	@Override
	public ArticleVO getArticleById(Long id) {
		Article article = baseMapper.selectById(id);
		List<ArticleVO> voList = buildVoList(ImmutableList.of(article));
		if (CollectionUtils.isEmpty(voList)) {
			return null;
		}
		return voList.get(0);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteByIds(List<Long> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return;
		}
		articleTagService.deleteByArticleIds(ids);
		this.removeByIds(ids);
	}

	@Override
	public PageDTO<ArticleVO> findByPage(PageDTO<Article> page, ArticleCriteria criteria) {
		PageDTO<Article> res = this.page(page, buildQueryWrapper(criteria));
		List<Article> records = res.getRecords();
		if (CollectionUtils.isEmpty(records)) {
			return new PageDTO<>();
		}

		List<ArticleVO> voList = buildVoList(records);
		return PageUtil.toPage(res, voList);
	}

	private List<ArticleVO> buildVoList(List<Article> records) {
		ArticleMapping mapping = ArticleMapping.INSTANCE;
		List<ArticleVO> voList = mapping.convertToVoList(records);
		Set<Long> articleIds = records.stream().map(Article::getId).collect(Collectors.toSet());

		List<ArticleTag> articleTagList = articleTagService.findByArticleIds(articleIds);
		Multimap<Long, Long> articleTagMap = LinkedHashMultimap.create();
		for (ArticleTag articleTag : articleTagList) {
			articleTagMap.put(articleTag.getArticleId(), articleTag.getTagId());
		}

		Set<Long> tagIds = articleTagList.stream().map(ArticleTag::getTagId).collect(Collectors.toSet());
		Set<Long> categoryIds = voList.stream().map(ArticleVO::getCategoryId).collect(Collectors.toSet());
		Map<Long, Tag> tagMap = findTagsAsMap(tagIds);
		Map<Long, Category> categoryMap = findCategoryAsMap(categoryIds);

		for (ArticleVO articleVO : voList) {
			if (!categoryMap.containsKey(articleVO.getCategoryId())) {
				continue;
			}
			Category category = categoryMap.get(articleVO.getCategoryId());
			articleVO.setCategory(category);

			List<Tag> tags = Lists.newArrayList();
			if (!articleTagMap.containsKey(articleVO.getId())) {
				continue;
			}
			Collection<Long> tagIdList = articleTagMap.get(articleVO.getId());
			for (Long tagId : tagIdList) {
				if (!tagMap.containsKey(tagId)) {
					continue;
				}
				Tag tag = tagMap.get(tagId);
				tags.add(tag);
			}
			articleVO.setTags(tags);
		}
		return voList;
	}

	private Map<Long, Category> findCategoryAsMap(Set<Long> categoryIds) {
		Map<Long, Category> categoryMap = Maps.newHashMap();
		List<Category> categories = categoryService
			.findList(CategoryCriteria.builder().categoryIds(categoryIds).build());
		if (CollectionUtils.isNotEmpty(categories)) {
			for (Category category : categories) {
				categoryMap.put(category.getId(), category);
			}
		}
		return categoryMap;
	}

	private Map<Long, Tag> findTagsAsMap(Set<Long> tagIds) {
		List<Tag> tagList = tagService.findList(TagCriteria.builder().tagIds(tagIds).build());
		Map<Long, Tag> tagMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(tagList)) {
			for (Tag tag : tagList) {
				tagMap.put(tag.getId(), tag);
			}
		}
		return tagMap;
	}

	private static LambdaQueryWrapper<Article> buildQueryWrapper(ArticleCriteria criteria) {
		LambdaQueryWrapper<Article> wrapper = Wrappers.<Article>lambdaQuery()
			.nested(criteria.isBlurryQuery(), k -> k.like(Article::getArticleName, criteria.getBlurry()))
			.eq(Objects.nonNull(criteria.getCategoryId()), Article::getCategoryId, criteria.getCategoryId())
			.in(CollectionUtils.isNotEmpty(criteria.getArticleIds()), Article::getId, criteria.getArticleIds());

		if (criteria.haveTime()) {
			wrapper.between(Article::getGmtCreate, criteria.getStartTime(), criteria.getEndTime());
		}
		return wrapper;
	}

}
