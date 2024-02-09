package com.libre.framework.blog.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.dto.ArticleIndex;

import java.util.List;

public interface ArticleSearchHandler {

	List<ArticleIndex> search(PageDTO<Article> page, ArticleCriteria criteria);

}
