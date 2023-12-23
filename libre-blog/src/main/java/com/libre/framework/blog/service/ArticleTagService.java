package com.libre.framework.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.blog.pojo.ArticleTag;

import java.util.List;
import java.util.Set;

public interface ArticleTagService extends IService<ArticleTag> {

	void deleteByArticleIds(List<Long> ids);

	List<ArticleTag> findByArticleIds(Set<Long> articleIds);

}
