package com.libre.framework.system.security.oauth2.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Oauth2ClientEnum {

	GITHUB("github"),

	GOOGLE("google"),

	GITEE("gitee"),;

	private final String name;

	public static Oauth2ClientEnum findByName(String name) {
		for (Oauth2ClientEnum oauth2ClientEnum : Oauth2ClientEnum.values()) {
			if (oauth2ClientEnum.getName().equals(name)) {
				return oauth2ClientEnum;
			}
		}

		throw new RuntimeException("不支持的客户端类型");
	}

}
