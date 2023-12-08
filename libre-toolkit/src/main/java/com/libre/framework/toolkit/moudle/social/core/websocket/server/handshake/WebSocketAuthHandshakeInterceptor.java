package com.libre.framework.toolkit.moudle.social.core.websocket.server.handshake;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.security.Principal;
import java.util.Map;

/**
 * 连接时验证用户是否登录
 *
 * @author L.cm
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketAuthHandshakeInterceptor implements HandshakeInterceptor {

	protected static final String WS_PRINCIPAL_ATTR_NAME = "__wsPrincipal__";

	private final WebSocketPrincipalResolve principalResolve;

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {

		// 解析握手的用户信息
		Principal principal = principalResolve.resolve(request);
		if (principal == null) {
			throw new HandshakeFailureException("WebSocket Handshake failure, accountId is null.");
		}
		attributes.put(WS_PRINCIPAL_ATTR_NAME, principal);
		log.info("WebSocket 握手成功 Principal:{}", principal);
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {

	}

}
