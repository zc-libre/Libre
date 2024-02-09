package com.libre.framework.blog.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageBoard {

	private Long id;

	private String content;

	private ArticleCount count;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

}
