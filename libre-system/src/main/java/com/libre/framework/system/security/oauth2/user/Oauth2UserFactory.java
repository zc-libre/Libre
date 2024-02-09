package com.libre.framework.system.security.oauth2.user;

import com.libre.framework.system.security.oauth2.SerializableToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class Oauth2UserFactory {

	public static OAuth2User buildOauth2User(SerializableToken serializableToken) {
		Oauth2ClientEnum clientEnum = Oauth2ClientEnum.findByName(serializableToken.getRegistrationId());
		if (Oauth2ClientEnum.GITHUB.equals(clientEnum)) {
			return new GithubUser(serializableToken.getAttributes());
		}
		else if (Oauth2ClientEnum.GITEE.equals(clientEnum)) {
			return new GiteeUser(serializableToken.getAttributes());
		}
		throw new RuntimeException("不支持的客户端类型");
	}

}
