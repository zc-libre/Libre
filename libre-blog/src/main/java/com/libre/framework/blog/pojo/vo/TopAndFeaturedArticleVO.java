package com.libre.framework.blog.pojo.vo;

import lombok.Data;

import java.util.List;

@Data
public class TopAndFeaturedArticleVO {

	private ArticleVO topArticle;

	private List<ArticleVO> features;

}
