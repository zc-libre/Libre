
package com.libre.framework.toolkit.moudle.social.core.websocket.common.message;

import lombok.Builder;
import lombok.Data;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;

/**
 * websocket 消息封装
 *
 * @author L.cm
 */
@Data
@Builder
public class WsMessage implements Message<Object>, Serializable {

	/**
	 * 账号信息
	 */
	private String user;
	/**
	 * topic destination
	 */
	private String destination;
	/**
	 * headers
	 */
	private MessageHeaders headers;
	/**
	 * payload
	 */
	private Object payload;

}
