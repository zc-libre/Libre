package com.libre.framework.system.security.oauth2;

import lombok.Data;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bty
 * @date 2023/2/12
 * @since 17
 **/
@Data
public class SerializableToken implements Serializable {

	public enum LOGIN_TYPE {

		USERNAME, OAUTH2, OIDC

	}

	private LOGIN_TYPE loginType;

	private String username;

	private String registrationId;

	private String token;

	private OAuth2User user;

	private Map<String, Object> attributes;

	private List<String> authorities;

	private Map<String, Object> idToken;

	private Map<String, Object> userInfo;

	public static SerializableToken adaptAuthentication(Authentication authentication) {
		SerializableToken serializableToken = null;
		List<String> authorityList = authentication.getAuthorities()
			.stream()
			.map(GrantedAuthority::getAuthority)
			.collect(Collectors.toList());

		if (authentication instanceof UsernamePasswordAuthenticationToken) {
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
			serializableToken = new SerializableToken();
			serializableToken.setLoginType(LOGIN_TYPE.USERNAME);
			serializableToken.setUsername(token.getName());
			serializableToken.setAuthorities(authorityList);
		}

		if (authentication instanceof OAuth2AuthenticationToken) {
			OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
			serializableToken = new SerializableToken();
			serializableToken.setUsername(token.getName());
			serializableToken.setAuthorities(authorityList);
			serializableToken.setRegistrationId(token.getAuthorizedClientRegistrationId());
			serializableToken.setUser(token.getPrincipal());

			OAuth2User principal = token.getPrincipal();
			if (principal instanceof OidcUser) {
				serializableToken.setLoginType(LOGIN_TYPE.OIDC);
				serializableToken.setUserInfo(((OidcUser) principal).getUserInfo().getClaims());
				// 注意，attributes里面可能存在不可被redis序列化的东西
				serializableToken.setAttributes(principal.getAttributes());
				serializableToken.setIdToken(((OidcUser) principal).getIdToken().getClaims());

			}
			else {
				serializableToken.setLoginType(LOGIN_TYPE.OAUTH2);
				// 注意，attributes里面可能存在不可被redis序列化的东西
				serializableToken.setAttributes(principal.getAttributes());
			}
		}
		return serializableToken;
	}

	public static Authentication reverseAuthentication(SerializableToken serializableToken,
			OAuth2ClientProperties clientProperties) {

		Set<SimpleGrantedAuthority> authoritySet = serializableToken.getAuthorities()
			.stream()
			.map(SimpleGrantedAuthority::new)
			.collect(Collectors.toSet());

		if (serializableToken.getLoginType().equals(LOGIN_TYPE.USERNAME)) {
			return new UsernamePasswordAuthenticationToken(serializableToken.getUsername(), null, authoritySet);
		}

		if (serializableToken.getLoginType().equals(LOGIN_TYPE.OAUTH2)) {
			return new OAuth2AuthenticationToken(new DefaultOAuth2User(authoritySet, serializableToken.getAttributes(),
					clientProperties.getProvider().get(serializableToken.getRegistrationId()).getUserNameAttribute()),
					authoritySet, serializableToken.getRegistrationId());
		}
		return null;
	}

}
