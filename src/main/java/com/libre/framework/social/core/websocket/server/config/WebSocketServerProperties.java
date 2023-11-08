package com.libre.framework.social.core.websocket.server.config;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * websocket 服务端配置
 *
 * @author L.cm
 */
@Getter
@Setter
@ConfigurationProperties(WebSocketServerProperties.PREFIX)
public class WebSocketServerProperties {

	public static final String PREFIX = "libre.websocket.server";

	/**
	 * 端点
	 */
	private List<String> endpoints = Lists.newArrayList("/ws");
	/**
	 * 跨域设置
	 */
	private List<String> allowedOrigins = Lists.newArrayList();
	/**
	 * 对外端点
	 */
	private List<String> simpleBrokers = Lists.newArrayList("/queue", "/topic");
	/**
	 * spring websocket 的 applicationDestinationPrefixes
	 */
	@Nullable
	private String[] applicationDestinationPrefixes = {"/app"};
	/**
	 * 点对点端点前缀
	 */
	@Nullable
	private String userDestinationPrefix = "/queue";
	/**
	 * json，big number 写出为 String，避免精度丢失
	 */
	private Boolean jsonBigNumToString = Boolean.TRUE;
	/**
	 * 启用在线账号存储，默认：false
	 */
	private Boolean enableAccountStore = Boolean.TRUE;


}
