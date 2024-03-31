package com.libre.framework.blog.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogUserDTO implements Serializable {

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 验证码
	 */
	private String validCode;

}
