
package com.libre.framework.social.core.websocket.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libre.framework.social.core.websocket.server.handshake.DefaultWebSocketPrincipalResolve;
import com.libre.framework.social.core.websocket.server.handshake.PrincipalHandshakeHandler;
import com.libre.framework.social.core.websocket.server.handshake.WebSocketAuthHandshakeInterceptor;
import com.libre.framework.social.core.websocket.server.handshake.WebSocketPrincipalResolve;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * websocket 配置
 *
 * @author L.cm
 */
@Slf4j
@EnableWebSocketMessageBroker
@Configuration
@EnableConfigurationProperties(WebSocketServerProperties.class)
public class WebSocketServerConfiguration {

	@Bean
	public WebSocketServerConfigurer webSocketConfigurer(PrincipalHandshakeHandler handshakeHandler,
														 WebSocketAuthHandshakeInterceptor authHandshakeInterceptor,
														 ObjectMapper objectMapper,
														 WebSocketServerProperties properties) {
		return new WebSocketServerConfigurer(handshakeHandler, authHandshakeInterceptor, objectMapper, properties);
	}

}
