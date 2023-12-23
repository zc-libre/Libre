package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.blog.mapper.ArticleTagMapper;
import com.libre.framework.blog.mapper.TagMapper;
import com.libre.framework.blog.pojo.ArticleTag;
import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.Tag;
import com.libre.framework.blog.pojo.dto.CategoryCriteria;
import com.libre.framework.blog.pojo.dto.TagCriteria;
import com.libre.framework.blog.pojo.dto.TagDTO;
import com.libre.framework.blog.pojo.vo.TagVO;
import com.libre.framework.blog.service.ArticleService;
import com.libre.framework.blog.service.ArticleTagService;
import com.libre.framework.blog.service.TagService;
import com.libre.framework.blog.service.mapstruct.TagMapping;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

	private final ArticleTagService articleTagService;

	@Override
	public void add(TagDTO tagDTO) {
		TagMapping mapping = TagMapping.INSTANCE;
		Tag tag = mapping.sourceToTarget(tagDTO);
		this.save(tag);
	}

	@Override
	public void edit(TagDTO tagDTO) {
		TagMapping mapping = TagMapping.INSTANCE;
		Tag tag = mapping.sourceToTarget(tagDTO);
		this.updateById(tag);
	}

	@Override
	public PageDTO<Tag> findByPage(PageDTO<Tag> page, TagCriteria criteria) {
		return this.page(page, buildQueryWrapper(criteria));
	}

	@Override
	public List<Tag> findList(TagCriteria criteria) {
		return this.list(buildQueryWrapper(criteria));
	}

	@Override
	public List<TagVO> findAllTags() {
		List<Tag> tags = this.list();
		TagMapping mapping = TagMapping.INSTANCE;
		List<TagVO> voList = mapping.convertToVoList(tags);
		List<ArticleTag> articleTags = articleTagService.list();
		Map<Long, List<ArticleTag>> tagArticleMap = articleTags.stream()
			.collect(Collectors.groupingBy(ArticleTag::getTagId));

		for (TagVO tag : voList) {
			if (!tagArticleMap.containsKey(tag.getId())) {
				continue;
			}
			List<ArticleTag> articleTagList = tagArticleMap.get(tag.getId());
			tag.setCount(articleTagList.size());
		}
		return voList;
	}

	private static LambdaQueryWrapper<Tag> buildQueryWrapper(TagCriteria criteria) {
		LambdaQueryWrapper<Tag> wrapper = Wrappers.<Tag>lambdaQuery()
			.nested(criteria.isBlurryQuery(), k -> k.like(Tag::getTagName, criteria.getBlurry()))
			.in(CollectionUtils.isNotEmpty(criteria.getTagIds()), Tag::getId, criteria.getTagIds());

		if (criteria.haveTime()) {
			wrapper.between(Tag::getGmtCreate, criteria.getStartTime(), criteria.getEndTime());
		}
		return wrapper;
	}

}
