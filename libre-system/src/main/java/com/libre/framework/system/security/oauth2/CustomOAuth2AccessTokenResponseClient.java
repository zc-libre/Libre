package com.libre.framework.system.security.oauth2;

import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.stereotype.Component;

/**
 * @author bty
 * @date 2023/3/8
 * @since 17
 **/
@Component
public class CustomOAuth2AccessTokenResponseClient
		implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {


	private final DefaultAuthorizationCodeTokenResponseClient proxy = new DefaultAuthorizationCodeTokenResponseClient();


	@Override
	public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) {
		return proxy.getTokenResponse(authorizationGrantRequest);
	}

}
