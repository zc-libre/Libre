package com.libre.framework.social.core.websocket.server.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;
import java.util.List;

/**
 * websocket 在线账号管理
 *
 * @author L.cm
 */
@Slf4j
@RequiredArgsConstructor
public class WsAccountManageImpl implements IWsAccountManage {

	private final IWsAccountStore wsAccountStore;

	@Override
	public List<String> getAccountList() {
		return wsAccountStore.listAll();
	}

	@Override
	public boolean isOnline(String accountId) {
		return wsAccountStore.has(accountId);
	}

	@EventListener
	public void onSocketConnected(SessionConnectedEvent event) {
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		Principal principal = sha.getUser();
		String accountId = principal.getName();
		wsAccountStore.put(accountId);
		log.info("WebSocket SessionId: {} Principal: {}", sha.getSessionId(), accountId);
	}

	@EventListener
	public void onSocketDisconnected(SessionDisconnectEvent event) {
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		Principal principal = sha.getUser();
		String accountId = principal.getName();
		wsAccountStore.remove(accountId);
		log.info("WebSocket SessionId: {} Principal: {}", sha.getSessionId(), accountId);
	}

}
