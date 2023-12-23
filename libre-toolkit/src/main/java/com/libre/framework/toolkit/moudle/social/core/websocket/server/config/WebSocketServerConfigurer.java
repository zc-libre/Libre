package com.libre.framework.toolkit.moudle.social.core.websocket.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libre.framework.toolkit.moudle.social.core.websocket.server.handshake.PrincipalHandshakeHandler;
import com.libre.framework.toolkit.moudle.social.core.websocket.server.handshake.WebSocketAuthHandshakeInterceptor;
import lombok.RequiredArgsConstructor;
import net.dreamlu.mica.core.utils.Charsets;
import net.dreamlu.mica.core.utils.ObjectUtil;
import net.dreamlu.mica.core.utils.StringUtil;
import org.springframework.messaging.converter.*;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

/**
 * WebSocketConfiguration配置
 *
 * @author L.cm
 */
@RequiredArgsConstructor
public class WebSocketServerConfigurer implements WebSocketMessageBrokerConfigurer {

	private final PrincipalHandshakeHandler principalHandshakeHandler;

	private final WebSocketAuthHandshakeInterceptor authHandshakeInterceptor;

	private final ObjectMapper objectMapper;

	private final WebSocketServerProperties properties;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		List<String> allowedOrigins = properties.getAllowedOrigins();
		if (ObjectUtil.isEmpty(allowedOrigins)) {
			allowedOrigins.add("*");
		}
		registry.addEndpoint("/websocket")
			.setAllowedOriginPatterns("*")
			// .addInterceptors(authHandshakeInterceptor)
			// .setHandshakeHandler(principalHandshakeHandler)
			.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 对外端点
		registry.enableSimpleBroker(properties.getSimpleBrokers().toArray(new String[0]));
		// 服务内的前缀
		String[] applicationDestinationPrefixes = properties.getApplicationDestinationPrefixes();
		if (applicationDestinationPrefixes != null) {
			registry.setApplicationDestinationPrefixes(applicationDestinationPrefixes);
		}
		// 用户的前缀
		String userDestinationPrefix = properties.getUserDestinationPrefix();
		if (StringUtil.isNotBlank(userDestinationPrefix)) {
			registry.setUserDestinationPrefix(userDestinationPrefix);
		}
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		// spring boot 的自动配置
		// WebSocketMessagingAutoConfiguration.WebSocketMessageConverterConfiguration 狠傻屌。
		// 问题：此处会先执行 messageConverters 里为空, spring boot 默认的也不能排除掉。
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setObjectMapper(objectMapper);
		DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
		resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
		converter.setContentTypeResolver(resolver);
		messageConverters.add(new StringMessageConverter(Charsets.UTF_8));
		messageConverters.add(new ByteArrayMessageConverter());
		messageConverters.add(converter);
		return false;
	}

}
