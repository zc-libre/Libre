package com.libre.framework.toolkit.moudle.social.core.websocket.server.cluster;

import com.libre.framework.toolkit.moudle.social.core.websocket.common.message.WsMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.utils.StringUtil;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.StringUtils;

/**
 * websocket 消息发送
 *
 * @author L.cm
 */
@Slf4j
@RequiredArgsConstructor
public class ClusterWebSocketSender {


	private final SimpMessagingTemplate messagingTemplate;

	/**
	 * 发送消息到 websocket 前端
	 *
	 * @param wsMessage WsMessage
	 */
	public void send(WsMessage wsMessage) {
		// websocket 的 destination
		String destination = wsMessage.getDestination();
		if (StringUtil.isBlank(destination)) {
			log.error("Websocket cluster message form redis sub destination is blank.");
			return;
		}
		// 拼接用户到后面，如果有用户
		String user = wsMessage.getUser();
		if (StringUtil.isNotBlank(user)) {
			destination += StringUtils.replace(user, "/", "%2F");
		}
		messagingTemplate.convertAndSend(destination, wsMessage.getPayload(), wsMessage.getHeaders());
	}

}
