
package com.libre.framework.social.core.websocket.client.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * websocket 客户端自动配置
 *
 * @author L.cm
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(WebSocketClientClusterProperties.class)
public class WebSocketClientConfiguration {

}
