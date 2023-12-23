package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.*;
import com.libre.boot.exception.BusinessException;
import com.libre.framework.blog.mapper.ArticleMapper;
import com.libre.framework.blog.pojo.*;
import com.libre.framework.blog.pojo.dto.*;
import com.libre.framework.blog.pojo.vo.*;
import com.libre.framework.blog.service.*;
import com.libre.framework.blog.service.mapstruct.ArticleMapping;
import com.libre.framework.common.constant.LibreConstants;
import com.libre.mybatis.util.PageUtil;
import com.libre.toolkit.core.StringUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

	private final ArticleTagService articleTagService;

	private final CategoryService categoryService;

	private final TagService tagService;

	private final BlogUserService blogUserService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addOrUpdate(ArticleDTO articleDTO) {
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
		criteria.setIsAbout(LibreConstants.NO);
		PageDTO<Article> res = this.page(page, buildQueryWrapper(criteria));
		List<Article> records = res.getRecords();
		if (CollectionUtils.isEmpty(records)) {
			return new PageDTO<>();
		}
		List<ArticleVO> voList = buildVoList(records);
		return PageUtil.toPage(res, voList);
	}

	@Override
	public List<Article> findList(ArticleCriteria criteria) {
		return this.list(buildQueryWrapper(criteria));
	}

	@Override
	public TopAndFeaturedArticleVO findTopAndFeaturedArticles() {
		ArticleCriteria criteria = ArticleCriteria.builder()
			.top(LibreConstants.ENABLE)
			.featured(LibreConstants.ENABLE)
			.build();
		List<Article> articleList = this.list(buildQueryWrapper(criteria));
		if (CollectionUtils.isEmpty(articleList)) {
			return new TopAndFeaturedArticleVO();
		}
		List<ArticleVO> voList = buildVoList(articleList);
		TopAndFeaturedArticleVO topAndFeaturedArticle = new TopAndFeaturedArticleVO();
		List<ArticleVO> featureList = Lists.newArrayList();
		for (ArticleVO articleVO : voList) {
			if (ObjectUtils.nullSafeEquals(LibreConstants.ENABLE, articleVO.getTop())) {
				topAndFeaturedArticle.setTopArticle(articleVO);
			}
			if (ObjectUtils.nullSafeEquals(LibreConstants.ENABLE, articleVO.getFeatured())) {
				featureList.add(articleVO);
			}
		}
		topAndFeaturedArticle.setFeatures(featureList);
		return topAndFeaturedArticle;
	}

	@Override
	public PageDTO<Archive> findArchives(PageDTO<Article> page, ArticleCriteria criteria) {
		PageDTO<Article> result = this.page(page, buildQueryWrapper(criteria));
		List<Article> records = result.getRecords();
		if (CollectionUtils.isEmpty(records)) {
			return PageUtil.toPage(result, Lists.newArrayList());
		}
		ArticleMapping mapping = ArticleMapping.INSTANCE;
		List<Archive> archives = mapping.convertToArchiveList(records);
		for (Archive archive : archives) {
			if (Objects.isNull(archive.getGmtCreate())) {
				continue;
			}
			CreateDate date = buildCreateDate(archive.getGmtCreate());
			archive.setDate(date);
		}
		return PageUtil.toPage(result, archives);
	}

	@Override
	public About findAboutMe() {
		ArticleCriteria criteria = ArticleCriteria.builder().isAbout(LibreConstants.YES).build();
		Article article = this.getOne(buildQueryWrapper(criteria));
		About about = new About();
		if (Objects.isNull(article)) {
			return about;
		}
		String content = article.getContent();
		ArticleCount count = buildArticleCount(content);
		about.setCount(count);
		about.setId(article.getId());
		about.setContent(article.getContent());
		about.setCreateTime(article.getGmtCreate());
		about.setUpdateTime(article.getGmtModified());
		return about;
	}

	@Override
	public PageDTO<ArticleVO> findPageByTagId(PageDTO<ArticleVO> page, ArticleCriteria criteria) {
		criteria.setIsAbout(LibreConstants.NO);
		PageDTO<ArticleVO> result = baseMapper.findPageByTagId(page, criteria);
		List<ArticleVO> voList = result.getRecords();
		if (CollectionUtils.isEmpty(voList)) {
			return PageUtil.toPage(page, Lists.newArrayList());
		}
		setArticleInfo(voList);
		return PageUtil.toPage(page, voList);
	}

	private static ArticleCount buildArticleCount(String content) {
		String cleanText = Jsoup.clean(content, Safelist.none());
		ArticleCount count = new ArticleCount();
		if (StringUtil.isBlank(cleanText)) {
			return count;
		}
		double length = cleanText.length();
		count.setSymbolsCount(Math.round(length / 100D) / 10 + "k");
		count.setSymbolsTime(Math.round(length / 40D) / 10 + "min");
		return count;
	}

	private List<ArticleVO> buildVoList(List<Article> records) {
		ArticleMapping mapping = ArticleMapping.INSTANCE;
		List<ArticleVO> voList = mapping.convertToVoList(records);
		setArticleInfo(voList);
		return voList;
	}

	private void setArticleInfo(List<ArticleVO> voList) {
		Set<Long> articleIds = voList.stream().map(ArticleVO::getId).collect(Collectors.toSet());
		List<ArticleTag> articleTagList = articleTagService.findByArticleIds(articleIds);
		Multimap<Long, Long> articleTagMap = LinkedHashMultimap.create();
		for (ArticleTag articleTag : articleTagList) {
			articleTagMap.put(articleTag.getArticleId(), articleTag.getTagId());
		}
		Set<Long> tagIds = articleTagList.stream().map(ArticleTag::getTagId).collect(Collectors.toSet());
		Set<Long> categoryIds = voList.stream().map(ArticleVO::getCategoryId).collect(Collectors.toSet());
		Map<Long, Tag> tagMap = findTagsAsMap(tagIds);
		Map<Long, Category> categoryMap = findCategoryAsMap(categoryIds);

		Author author = blogUserService.getBlogAuthor();
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

			ArticleCount count = buildArticleCount(articleVO.getContent());
			articleVO.setCount(count);
			articleVO.setTags(tags);
			articleVO.setAuthor(author);
			CreateDate date = buildCreateDate(articleVO.getGmtCreate());
			articleVO.setDate(date);
		}
	}

	private static CreateDate buildCreateDate(LocalDateTime dateTime) {
		CreateDate date = new CreateDate();
		if (Objects.isNull(dateTime)) {
			return date;
		}
		date.setYear(dateTime.getYear());
		Month month = dateTime.getMonth();
		date.setMonth(month.getDisplayName(TextStyle.SHORT, Locale.CHINA));
		date.setDay(dateTime.getDayOfMonth());
		return date;
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
			.eq(Objects.nonNull(criteria.getTop()), Article::getTop, criteria.getTop())
			.eq(Objects.nonNull(criteria.getFeatured()), Article::getFeatured, criteria.getFeatured())
			.eq(Objects.nonNull(criteria.getIsAbout()), Article::getIsAbout, criteria.getIsAbout())
			.in(CollectionUtils.isNotEmpty(criteria.getArticleIds()), Article::getId, criteria.getArticleIds());
		if (criteria.haveTime()) {
			wrapper.between(Article::getGmtCreate, criteria.getStartTime(), criteria.getEndTime());
		}
		wrapper.orderByDesc(Article::getGmtCreate);
		return wrapper;
	}

}
