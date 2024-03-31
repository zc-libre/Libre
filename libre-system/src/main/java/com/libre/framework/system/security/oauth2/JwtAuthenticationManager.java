package com.libre.framework.system.security.oauth2;

import com.libre.boot.toolkit.RequestUtils;
import com.libre.framework.common.security.dto.AuthUser;
import com.libre.framework.common.security.dto.JwtUser;
import com.libre.framework.common.security.support.SecurityUtil;
import com.libre.framework.system.security.auth.LibreWebAuthenticationDetails;
import com.libre.framework.system.security.configuration.LibreSecurityProperties;
import com.libre.framework.system.security.jwt.JwtTokenService;
import com.libre.framework.system.security.jwt.JwtTokenStore;
import com.libre.framework.toolkit.moudle.log.support.SysLogConstant;
import com.libre.framework.toolkit.moudle.log.support.SysLogEvent;
import com.libre.framework.toolkit.moudle.log.support.SysLogType;
import com.libre.framework.toolkit.moudle.log.support.SysLogUtil;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.Objects;

/**
 * 用于BearerToken的认证，具体由{@link TokenService}实现 <br/>
 *
 * @author bty
 * @date 2023/2/6
 * @since 17
 **/
@Component
@RequiredArgsConstructor
public class JwtAuthenticationManager implements AuthenticationManager {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationManager.class);

	private final JwtTokenStore tokenService;

	private final OAuth2ClientProperties properties;

	private final LibreSecurityProperties securityProperties;

	private final JwtTokenStore tokenStore;

	/**
	 * @param authentication {@link JwtAuthenticationToken}
	 * @return {@link UsernamePasswordAuthenticationToken} or
	 * {@link OAuth2AuthenticationToken}
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authentication;
		String token = jwtToken.getToken();
		try {
			SerializableToken serializableToken = tokenService.getOauth2Token(token);
			Authentication reverseAuthentication = SerializableToken.reverseAuthentication(serializableToken,
					properties);
			if (reverseAuthentication == null) {
				throw new SessionAuthenticationException("session not found");
			}
			logger.info("bearer token is authenticated , authentication is :{}", authentication);
			return reverseAuthentication;
		}
		catch (RuntimeException e) {
			throw new SessionAuthenticationException(e.getMessage());
		}
	}

}
