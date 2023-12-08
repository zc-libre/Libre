
package com.libre.framework.toolkit.moudle.social.core.websocket.client.core;


import com.libre.framework.toolkit.moudle.social.core.websocket.common.message.WsMessage;

/**
 * websocket 客户端
 *
 * @author L.cm
 */
public interface WsClient {

	/**
	 * Send a message to a default destination.
	 *
	 * @param message the message to send
	 */
	void send(WsMessage message);

}
