package com.libre.framework.toolkit.moudle.social.core.websocket.server.cluster;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * websocket 服务端集群配置
 *
 * @author L.cm
 */
@AutoConfiguration
@ConditionalOnProperty(name = "enabled", prefix = ClusterWebSocketProperties.PREFIX, havingValue = "true",
		matchIfMissing = true)
public class ClusterWebSocketConfiguration {

	@Bean
	public ClusterWebSocketSender clusterWebSocketSender(SimpMessagingTemplate messagingTemplate) {
		return new ClusterWebSocketSender(messagingTemplate);
	}

}
