package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.blog.common.CacheConstants;
import com.libre.framework.blog.mapper.BlogUserMapper;
import com.libre.framework.blog.pojo.BlogUser;
import com.libre.framework.blog.pojo.dto.Author;
import com.libre.framework.blog.pojo.dto.BlogUserCriteria;
import com.libre.framework.blog.pojo.vo.Statistic;
import com.libre.framework.blog.service.BlogUserService;
import com.libre.framework.blog.service.StatisticService;
import com.libre.framework.blog.service.mapstruct.BlogUserMapping;
import com.libre.framework.common.constant.LibreConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = CacheConstants.BLOG_USER_CACHE_KEY)
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {

	private final StatisticService statisticService;

	@Override
	@Cacheable(key = "#authorKey")
	public Author getBlogAuthor(String authorKey) {
		BlogUser blogUser = baseMapper
			.selectOne(Wrappers.<BlogUser>lambdaQuery().eq(BlogUser::getIsAuthor, LibreConstants.YES));
		BlogUserMapping mapping = BlogUserMapping.INSTANCE;
		Author author = mapping.sourceToTarget(blogUser);
		author.setName(blogUser.getUsername());

		Statistic statistic = statisticService.statistic();
		author.setArticles(statistic.getArticles());
		author.setTags(statistic.getTags());
		author.setCategories(statistic.getCategories());
		return author;
	}

	@Override
	public List<BlogUser> findCriteria(BlogUserCriteria criteria) {
		return this.list(buildQueryWrapper(criteria));
	}

	private static LambdaQueryWrapper<BlogUser> buildQueryWrapper(BlogUserCriteria criteria) {
		return Wrappers.<BlogUser>lambdaQuery()
			.eq(Objects.nonNull(criteria.getUserId()), BlogUser::getId, criteria.getUserId())
			.in(CollectionUtils.isNotEmpty(criteria.getUserIds()), BlogUser::getId, criteria.getUserIds());
	}

}
