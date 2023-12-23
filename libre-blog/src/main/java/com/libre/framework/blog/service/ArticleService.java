package com.libre.framework.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.blog.pojo.About;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.dto.ArticleDTO;
import com.libre.framework.blog.pojo.vo.Archive;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.framework.blog.pojo.vo.TopAndFeaturedArticleVO;

import java.util.List;

public interface ArticleService extends IService<Article> {

	void addOrUpdate(ArticleDTO article);

	void edit(ArticleDTO article);

	ArticleVO getArticleById(Long id);

	void deleteByIds(List<Long> ids);

	PageDTO<ArticleVO> findByPage(PageDTO<Article> page, ArticleCriteria criteria);

	List<Article> findList(ArticleCriteria criteria);

	TopAndFeaturedArticleVO findTopAndFeaturedArticles();

	PageDTO<Archive> findArchives(PageDTO<Article> page, ArticleCriteria criteria);

	About findAboutMe();

	PageDTO<ArticleVO> findPageByTagId(PageDTO<ArticleVO> page, ArticleCriteria criteria);
}
