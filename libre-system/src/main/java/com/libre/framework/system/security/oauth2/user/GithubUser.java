package com.libre.framework.system.security.oauth2.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collections;
import java.util.Map;

@Getter
@Setter
public class GithubUser extends DefaultOAuth2User {

	private String nickName;

	private String email;

	private String avatar;

	private Boolean isAuthor;

	private String token;

	/**
	 * Constructs a {@code DefaultOAuth2User} using the provided parameters.
	 * @param attributes the attributes about the user {@link #getAttributes()}
	 */
	public GithubUser(Map<String, Object> attributes) {
		super(Collections.emptyList(), attributes, "name");
		this.avatar = (String) attributes.get("avatar_url");
		this.nickName = (String) attributes.get("name");
		this.email = (String) attributes.get("email");
		this.isAuthor = Boolean.FALSE;
	}

}
