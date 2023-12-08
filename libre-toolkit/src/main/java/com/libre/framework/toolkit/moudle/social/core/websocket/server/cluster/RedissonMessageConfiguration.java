package com.libre.framework.toolkit.moudle.social.core.websocket.server.cluster;

import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * websocket
 *
 * @author L.cm
 */
@AutoConfiguration
@ConditionalOnProperty(name = "enabled", prefix = ClusterWebSocketProperties.PREFIX, havingValue = "true",
		matchIfMissing = true)
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ClusterWebSocketProperties.class)
public class RedissonMessageConfiguration {

	@Bean
	public RedissonWebSocketMessageListener redissonWebSocketMessageListener(Environment environment,
			RedissonClient redisson, ClusterWebSocketProperties properties, ClusterWebSocketSender webSocketSender) {
		return new RedissonWebSocketMessageListener(environment, redisson, properties, webSocketSender);
	}

}
