package com.libre.framework.system.security.oauth2;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author bty
 * @date 2023/2/13
 * @since 17
 **/
@Slf4j
@Data
public class SerializableOAuth2AuthorizationRequest implements Serializable {

	private String authorizationUri;

	private String authorizationGrantType;

	private String responseType;

	private String clientId;

	private String redirectUri;

	private Set<String> scopes;

	private String state;

	private Map<String, Object> additionalParameters;

	private String authorizationRequestUri;

	private Map<String, Object> attributes;


	public static SerializableOAuth2AuthorizationRequest adapt(OAuth2AuthorizationRequest request) {
		SerializableOAuth2AuthorizationRequest serializable = new SerializableOAuth2AuthorizationRequest();
		serializable.setAuthorizationUri(request.getAuthorizationUri());
		serializable.setAuthorizationGrantType(request.getGrantType().getValue());
		serializable.setResponseType(request.getResponseType().getValue());
		serializable.setClientId(request.getClientId());
		serializable.setRedirectUri(request.getRedirectUri());
		serializable.setScopes(request.getScopes());
		serializable.setState(request.getState());
		serializable.setAdditionalParameters(request.getAdditionalParameters());
		serializable.setAuthorizationRequestUri(request.getAuthorizationRequestUri());
		serializable.setAttributes(request.getAttributes());
		return serializable;
	}

	public static OAuth2AuthorizationRequest reverse(SerializableOAuth2AuthorizationRequest serializable) {
		if (Objects.isNull(serializable)) {
			log.error("SerializableOAuth2AuthorizationRequest is null");
			return null;
		}

		OAuth2AuthorizationRequest.Builder requestBuilder;
		if (serializable.getAuthorizationGrantType().equals(AuthorizationGrantType.AUTHORIZATION_CODE.getValue())) {
			requestBuilder = OAuth2AuthorizationRequest.authorizationCode();
		}
		else {
			// TODO
			requestBuilder = OAuth2AuthorizationRequest.authorizationCode();
		}

		requestBuilder.authorizationUri(serializable.getAuthorizationUri())
			.clientId(serializable.getClientId())
			.redirectUri(serializable.getRedirectUri())
			.scopes(serializable.getScopes())
			.state(serializable.getState())
			.additionalParameters(serializable.getAdditionalParameters())
			.authorizationRequestUri(serializable.getAuthorizationRequestUri())
			.attributes(serializable.getAttributes());

		return requestBuilder.build();
	}

}
