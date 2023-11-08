package com.libre.framework.social.core.websocket.server.handshake;

import com.libre.framework.security.jwt.JwtTokenService;
import com.libre.framework.social.core.websocket.common.user.WsPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.security.Principal;

/**
 * 默认的 Principal 解析
 *
 * @author L.cm
 */
@Component
@RequiredArgsConstructor
public class DefaultWebSocketPrincipalResolve implements WebSocketPrincipalResolve {

	private final JwtTokenService jwtTokenService;


	@Nullable
	@Override
	public Principal resolve(ServerHttpRequest request) {
		String token = jwtTokenService.getToken(request);
		String accountId = jwtTokenService.getSubject(token);
		return new WsPrincipal(accountId);
	}

}
