package com.libre.framework.social.core.websocket.server.cluster;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * websocket 服务端集群配置
 *
 * @author L.cm
 */
@Getter
@Setter
@ConfigurationProperties(ClusterWebSocketProperties.PREFIX)
public class ClusterWebSocketProperties {

	public static final String PREFIX = "libre.websocket.cluster";

	/**
	 * 是否开启 websocket 集群，默认：true
	 */
	private boolean enabled = true;

	/**
	 * redis sub topic prefix
	 */
	private String redisSubTopicPrefix = "websocket:cluster:";

}
