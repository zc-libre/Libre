package com.libre.framework.blog.pojo.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Data
public class BlogOauth2User implements OAuth2User {

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


	@Override
	public Map<String, Object> getAttributes() {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getName() {
		return this.username;
	}

}
