package com.libre.framework.security.oauth2.config;

import com.libre.framework.security.oauth2.support.CustomOAuth2AccessTokenGenerator;
import com.libre.framework.security.oauth2.support.core.CustomeOAuth2TokenCustomizer;
import com.libre.framework.security.oauth2.support.core.FormIdentityLoginConfigurer;
import com.libre.framework.security.oauth2.support.core.OAuth2DaoAuthenticationProvider;
import com.libre.framework.security.oauth2.support.handler.OAuth2AuthenticationFailureEventHandler;
import com.libre.framework.security.oauth2.support.handler.OAuth2AuthenticationSuccessEventHandler;
import com.libre.framework.security.oauth2.support.password.OAuth2ResourceOwnerPasswordAuthenticationConverter;
import com.libre.framework.security.oauth2.support.password.OAuth2ResourceOwnerPasswordAuthenticationProvider;
import com.libre.framework.security.oauth2.support.sms.OAuth2ResourceOwnerSmsAuthenticationConverter;
import com.libre.framework.security.oauth2.support.sms.OAuth2ResourceOwnerSmsAuthenticationProvider;
import com.libre.security.constant.SecurityConstants;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.token.DelegatingOAuth2TokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2RefreshTokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import org.springframework.security.oauth2.server.authorization.web.authentication.*;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author lengleng
 * @date 2022/5/27
 *
 * 认证服务器配置
 */
@Configuration
@RequiredArgsConstructor
public class AuthorizationServerConfiguration {

	private final OAuth2AuthorizationService authorizationService;

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
		OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();

		http.apply(authorizationServerConfigurer.tokenEndpoint((tokenEndpoint) -> {// 个性化认证授权端点
			tokenEndpoint.accessTokenRequestConverter(accessTokenRequestConverter()) // 注入自定义的授权认证Converter
					.accessTokenResponseHandler(new OAuth2AuthenticationSuccessEventHandler()) // 登录成功处理器
					.errorResponseHandler(new OAuth2AuthenticationFailureEventHandler());// 登录失败处理器
		}).clientAuthentication(oAuth2ClientAuthenticationConfigurer -> // 个性化客户端认证
		oAuth2ClientAuthenticationConfigurer.errorResponseHandler(new OAuth2AuthenticationFailureEventHandler()))// 处理客户端认证异常
				.authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint// 授权码端点个性化confirm页面
						.consentPage(SecurityConstants.CUSTOM_CONSENT_PAGE_URI)));

		AntPathRequestMatcher[] requestMatchers = new AntPathRequestMatcher[] {
				AntPathRequestMatcher.antMatcher("/token/**"), AntPathRequestMatcher.antMatcher("/actuator/**"),
				AntPathRequestMatcher.antMatcher("/css/**"), AntPathRequestMatcher.antMatcher("/error") };

		http.authorizeHttpRequests(authorizeRequests -> {
			// 自定义接口、端点暴露
			authorizeRequests.requestMatchers(requestMatchers).permitAll();
			authorizeRequests.anyRequest().authenticated();
		}).apply(authorizationServerConfigurer.authorizationService(authorizationService)// redis存储token的实现
				.authorizationServerSettings(AuthorizationServerSettings.builder().issuer("https://www.libre.com")
						.tokenEndpoint("/api/oauth2/token").build()));
		http.apply(new FormIdentityLoginConfigurer());
		DefaultSecurityFilterChain securityFilterChain = http.build();

		// 注入自定义授权模式实现
		addCustomOAuth2GrantAuthenticationProvider(http);
		return securityFilterChain;
	}

	/**
	 * 令牌生成规则实现 </br>
	 * client:username:uuid
	 * @return OAuth2TokenGenerator
	 */
	@Bean
	@SuppressWarnings("rawtypes")
	public OAuth2TokenGenerator oAuth2TokenGenerator() {
		CustomOAuth2AccessTokenGenerator accessTokenGenerator = new CustomOAuth2AccessTokenGenerator();
		// 注入Token 增加关联用户信息
		accessTokenGenerator.setAccessTokenCustomizer(new CustomeOAuth2TokenCustomizer());
		return new DelegatingOAuth2TokenGenerator(accessTokenGenerator, new OAuth2RefreshTokenGenerator());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	/**
	 * request -> xToken 注入请求转换器
	 * @return DelegatingAuthenticationConverter
	 */
	private AuthenticationConverter accessTokenRequestConverter() {
		return new DelegatingAuthenticationConverter(Arrays.asList(
				new OAuth2ResourceOwnerPasswordAuthenticationConverter(),
				new OAuth2ResourceOwnerSmsAuthenticationConverter(), new OAuth2RefreshTokenAuthenticationConverter(),
				new OAuth2ClientCredentialsAuthenticationConverter(),
				new OAuth2AuthorizationCodeAuthenticationConverter(),
				new OAuth2AuthorizationCodeRequestAuthenticationConverter()));
	}

	/**
	 * 注入授权模式实现提供方
	 *
	 * 1. 密码模式 </br>
	 * 2. 短信登录 </br>
	 *
	 */
	@SuppressWarnings("unchecked")
	private void addCustomOAuth2GrantAuthenticationProvider(HttpSecurity http) {
		AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
		OAuth2AuthorizationService authorizationService = http.getSharedObject(OAuth2AuthorizationService.class);

		OAuth2ResourceOwnerPasswordAuthenticationProvider resourceOwnerPasswordAuthenticationProvider = new OAuth2ResourceOwnerPasswordAuthenticationProvider(
				authenticationManager, authorizationService, oAuth2TokenGenerator());

		OAuth2ResourceOwnerSmsAuthenticationProvider resourceOwnerSmsAuthenticationProvider = new OAuth2ResourceOwnerSmsAuthenticationProvider(
				authenticationManager, authorizationService, oAuth2TokenGenerator());

		// 处理 UsernamePasswordAuthenticationToken
		http.authenticationProvider(new OAuth2DaoAuthenticationProvider());
		// 处理 OAuth2ResourceOwnerPasswordAuthenticationToken
		http.authenticationProvider(resourceOwnerPasswordAuthenticationProvider);
		// 处理 OAuth2ResourceOwnerSmsAuthenticationToken
		http.authenticationProvider(resourceOwnerSmsAuthenticationProvider);
	}

}
