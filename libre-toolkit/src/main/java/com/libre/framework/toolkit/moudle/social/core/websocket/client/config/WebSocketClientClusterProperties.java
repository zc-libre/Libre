
package com.libre.framework.toolkit.moudle.social.core.websocket.client.config;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * websocket 客户端集群配置
 *
 * @author L.cm
 */
@Getter
@Setter
@Validated
@ConfigurationProperties(WebSocketClientClusterProperties.PREFIX)
public class WebSocketClientClusterProperties {

	public static final String PREFIX = "libre.websocket.client.cluster";

	/**
	 * 是否使用 websocket 集群，默认：true
	 */
	private boolean enabled = true;

	/**
	 * redis sub topic prefix
	 */
	private String redisSubTopicPrefix = "websocket:cluster:";

	/**
	 * 集群的服务名，必须
	 */
	@NotNull
	private String serverAppName = "libre";

}
