
package com.libre.framework.toolkit.moudle.social.core.websocket.server.handshake;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * Principal 解析
 *
 * @author L.cm
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PrincipalHandshakeHandler extends DefaultHandshakeHandler {

	@Nullable
	@Override
	protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
		return (Principal) attributes.get(WebSocketAuthHandshakeInterceptor.WS_PRINCIPAL_ATTR_NAME);
	}

}
