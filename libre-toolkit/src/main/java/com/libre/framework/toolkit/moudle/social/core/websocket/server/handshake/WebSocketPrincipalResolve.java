package com.libre.framework.toolkit.moudle.social.core.websocket.server.handshake;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.lang.Nullable;

import java.security.Principal;

/**
 * Principal Resolve
 *
 * @author L.cm
 */
public interface WebSocketPrincipalResolve {

	/**
	 * 解析 Principal
	 * @param request ServerHttpRequest
	 * @return Principal
	 */
	@Nullable
	Principal resolve(ServerHttpRequest request);

}
