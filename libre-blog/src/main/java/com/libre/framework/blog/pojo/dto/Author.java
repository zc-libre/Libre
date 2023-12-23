package com.libre.framework.blog.pojo.dto;

import lombok.Data;

@Data
public class Author {

	private Long id;

	private String name;

	private String avatar;

	private String link;

	private String description;

	private Long articles;

	private Long tags;

	private Long categories;

}
