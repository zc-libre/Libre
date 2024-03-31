package com.libre.framework.system.security.oauth2.user;

import com.libre.framework.system.security.oauth2.SerializableToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class Oauth2UserFactory {

	public static OAuth2User buildOauth2User(SerializableToken serializableToken) {
		Oauth2ClientEnum clientEnum = Oauth2ClientEnum.findByName(serializableToken.getRegistrationId());
		if (Oauth2ClientEnum.GITHUB.equals(clientEnum)) {
			GithubUser githubUser = new GithubUser(serializableToken.getAttributes());
			githubUser.setToken(serializableToken.getToken());
			return githubUser;
		}
		else if (Oauth2ClientEnum.GITEE.equals(clientEnum)) {
			GiteeUser giteeUser = new GiteeUser(serializableToken.getAttributes());
			giteeUser.setToken(serializableToken.getToken());
			giteeUser.setClientId(serializableToken.getRegistrationId());
			return giteeUser;
		}
		throw new RuntimeException("不支持的客户端类型");
	}

}
