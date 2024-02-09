package com.libre.framework.system.security.oauth2;

import com.libre.boot.toolkit.RequestUtils;
import com.libre.framework.system.security.jwt.JwtTokenService;
import com.libre.framework.system.security.jwt.JwtTokenStore;
import com.libre.framework.system.security.oauth2.user.Oauth2UserFactory;
import com.libre.toolkit.result.R;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;

@Component
@RequiredArgsConstructor
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final JwtTokenService tokenService;

	private final JwtTokenStore jwtTokenStore;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		SerializableToken serializableToken = SerializableToken.adaptAuthentication(authentication);
		if (serializableToken == null) {
			throw new ProviderNotFoundException("AuthenticationType not support");
		}
		String token = tokenService.createOauth2Token(serializableToken, Duration.ofHours(1));
		serializableToken.setToken(token);
		jwtTokenStore.saveOauth2Token(request, serializableToken, token, Duration.ofHours(1));
		OAuth2User oAuth2User = Oauth2UserFactory.buildOauth2User(serializableToken);
		RequestUtils.renderJson(response, R.data(oAuth2User));
	}

}
