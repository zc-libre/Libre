package com.libre.framework.blog.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogUser {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 账号
	 */
	private String username;

	/**
	 * 用户名称
	 */
	private String nickName;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 描述
	 */
	private String description;

	private Integer isAuthor;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

}
