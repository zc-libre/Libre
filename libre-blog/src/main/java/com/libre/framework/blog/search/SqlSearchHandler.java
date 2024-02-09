package com.libre.framework.blog.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.dto.ArticleIndex;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SqlSearchHandler implements ArticleSearchHandler {

	@Override
	public List<ArticleIndex> search(PageDTO<Article> page, ArticleCriteria criteria) {
		return null;
	}

}
