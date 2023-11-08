package com.libre.framework.social.core.websocket.client.config;

import com.libre.framework.social.core.websocket.client.core.WsClient;
import com.libre.framework.social.core.websocket.client.support.RedissonWsClientImpl;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson websocket 客户端配置
 *
 * @author L.cm
 */
@ConditionalOnClass(Redisson.class)
@ConditionalOnProperty(
	name = "enabled",
	prefix = WebSocketClientClusterProperties.PREFIX,
	havingValue = "true",
	matchIfMissing = true
)
@Configuration(proxyBeanMethods = false)
public class RedissonWsClientConfiguration {

	@Bean
	public WsClient wsClient(RedissonClient redisson,
                             WebSocketClientClusterProperties properties) {
		return new RedissonWsClientImpl(redisson, properties);
	}

}
