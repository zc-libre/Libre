package com.libre.framework.blog.pojo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleDTO {

	private Long id;

	private String cover;

	private String articleName;

	private String summary;

	private String content;

	private Integer status;

	private Integer top;

	private Integer featured;

	private Long categoryId;

    private List<Long> tagIds;

}
