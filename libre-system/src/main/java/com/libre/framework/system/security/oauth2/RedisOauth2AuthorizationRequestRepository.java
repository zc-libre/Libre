package com.libre.framework.system.security.oauth2;

import com.google.common.base.Strings;
import com.libre.toolkit.core.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisOauth2AuthorizationRequestRepository
		implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

	public static final String DEFAULT_INFLIGHT_REQUEST_REDIS_KEY_PREFIX = "OAUTH2_INFLIGHT_REQUEST:";

	private String redisKeyPrefix = DEFAULT_INFLIGHT_REQUEST_REDIS_KEY_PREFIX;

	private final RedisTemplate<String, Object> redisTemplate;

	public void setRedisKeyPrefix(String redisKeyPrefix) {
		this.redisKeyPrefix = redisKeyPrefix;
	}

	private String createRedisKey(String state) {
		return this.redisKeyPrefix + state;
	}

	private String getStateParameter(HttpServletRequest request) {
		return request.getParameter(OAuth2ParameterNames.STATE);
	}

	@Override
	public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
		String state = getStateParameter(request);
		if (Strings.isNullOrEmpty(state)) {
			return null;
		}
		SerializableOAuth2AuthorizationRequest serializable = (SerializableOAuth2AuthorizationRequest) redisTemplate
			.opsForValue()
			.get(createRedisKey(state));
		return SerializableOAuth2AuthorizationRequest.reverse(serializable);
	}

	@Override
	public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Assert.notNull(request, "request cannot be null");
		Assert.notNull(response, "response cannot be null");
		if (authorizationRequest == null) {
			this.removeAuthorizationRequest(request, response);
			return;
		}
		String state = authorizationRequest.getState();
		Assert.hasText(state, "authorizationRequest.state cannot be empty");

		SerializableOAuth2AuthorizationRequest adapt = SerializableOAuth2AuthorizationRequest
			.adapt(authorizationRequest);

		try {
			redisTemplate.opsForValue().set(createRedisKey(state), adapt, 5, TimeUnit.MINUTES);
		}
		catch (Exception e) {
			throw new SessionAuthenticationException("In-flight Authorization Request store failed");
		}
	}

	@Override
	public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request,
			HttpServletResponse response) {
		Assert.notNull(request, "request cannot be null");
		String state = this.getStateParameter(request);
		if (StringUtil.isBlank(state)) {
			return null;
		}
		try {
			SerializableOAuth2AuthorizationRequest serializable = (SerializableOAuth2AuthorizationRequest) redisTemplate
				.opsForValue()
				.get(createRedisKey(state));
			redisTemplate.delete(createRedisKey(state));
			return SerializableOAuth2AuthorizationRequest.reverse(serializable);
		}
		catch (Exception e) {
			throw new SessionAuthenticationException(e.getMessage());
		}
	}

}
