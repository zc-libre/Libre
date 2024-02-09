package com.libre.framework.blog.pojo.vo;

import lombok.Data;

import java.util.List;

@Data
public class CommentPage {

	private Long total;

	private Long size;

	private Long current;

	private List<CommentVO> records;

	private ArticleVO article;

}
