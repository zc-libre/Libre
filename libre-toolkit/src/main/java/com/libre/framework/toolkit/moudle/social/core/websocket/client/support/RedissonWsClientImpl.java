
package com.libre.framework.toolkit.moudle.social.core.websocket.client.support;

import com.libre.framework.toolkit.moudle.social.core.websocket.client.core.WsClient;
import com.libre.framework.toolkit.moudle.social.core.websocket.client.config.WebSocketClientClusterProperties;
import com.libre.framework.toolkit.moudle.social.core.websocket.common.message.WsMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;

/**
 * redisson 消息发布
 *
 * @author L.cm
 */
@Slf4j
@RequiredArgsConstructor
public class RedissonWsClientImpl implements WsClient {

	private final RedissonClient redisson;

	private final WebSocketClientClusterProperties properties;

	@Override
	public void send(WsMessage message) {
		// 拼接 topic name
		String redisSubTopic = getRedisSubTopic(properties);
		log.info("websocket redisson pub topic:{}", redisSubTopic);
		RTopic topic = redisson.getTopic(redisSubTopic);
		// publish
		topic.publish(message);
	}

	private static String getRedisSubTopic(WebSocketClientClusterProperties properties) {
		return properties.getRedisSubTopicPrefix() + properties.getServerAppName();
	}

}
