package com.libre.framework.system.security.oauth2;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.util.Assert;

import java.util.Collections;

/**
 * @author bty
 * @date 2023/2/6
 * @since 17
 **/
@Getter
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

	private final String token;

	/**
	 * Create a BearerTokenAuthenticationToken using the provided parameter(s)
	 * @param token - the bearer token
	 */
	public JwtAuthenticationToken(String token) {
		super(Collections.emptyList());
		Assert.hasText(token, "token cannot be empty");
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		return getToken();
	}

	@Override
	public Object getPrincipal() {
		return getToken();
	}

}
