package com.libre.framework.im.core.handler;

import com.libre.boot.exception.ErrorType;
import com.libre.boot.exception.ErrorUtil;
import com.libre.boot.exception.LibreErrorEvent;
import com.libre.framework.security.config.LibreSecurityProperties;
import com.libre.framework.im.config.WebsocketServerProperties;
import com.libre.framework.im.core.constant.LibreIMConstants;
import com.libre.framework.im.core.mapstruct.MessageMapping;
import com.libre.framework.im.core.message.TextMessage;
import com.libre.framework.im.core.message.enums.ConnectType;
import com.libre.framework.im.core.message.enums.MessageBodyType;
import com.libre.framework.im.core.message.handler.MessageHandler;
import com.libre.framework.im.core.message.handler.MessageHandlerFactory;
import com.libre.framework.im.core.message.handler.TextMessageHandler;
import com.libre.framework.im.core.proto.TextMessageProto;
import com.libre.framework.im.core.session.SessionManager;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.Clock;

/**
 * @author ZC
 * @date 2021/8/8 0:03
 */
@Slf4j
@Component
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class WebSocketMessageHandler extends SimpleChannelInboundHandler<TextMessageProto.TextMessage> {

	protected final WebsocketServerProperties properties;

	private final SessionManager sessionManager;

	private final ApplicationEventPublisher publisher;

	private final LibreSecurityProperties securityProperties;

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object event) throws Exception {

		if (event instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
			// 协议握手成功完成
			log.info("NettyWebSocketHandler.userEventTriggered --> : 协议握手成功完成");
			// 检查用户token
			AttributeKey<String> attributeKey = AttributeKey.valueOf(securityProperties.getJwtToken().getHeader());
			// 从通道中获取用户token
			String token = ctx.channel().attr(attributeKey).get();
			log.info("token: {}", token);
		}

		Long sessionId = ctx.channel().attr(LibreIMConstants.SERVER_SESSION_ID).get();

		// 发送心跳包
		if (event instanceof IdleStateEvent && ((IdleStateEvent) event).state().equals(IdleState.WRITER_IDLE)) {
			sendHeartBeatMessage(sessionId);
		}

		if (event instanceof IdleStateEvent && ((IdleStateEvent) event).state().equals(IdleState.READER_IDLE)) {
			Long lastTime = ctx.channel().attr(LibreIMConstants.SERVER_SESSION_HEART_BEAT).get();
			if ((Clock.systemDefaultZone().millis() - lastTime) / 1000 >= 60) {
				log.info("与客户端失去连接, 断开连接");
				sessionManager.remove(sessionId);
			}
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextMessageProto.TextMessage msg) throws Exception {
		log.debug("message received: {}", msg);

		if (ConnectType.HEART_BEAT.getType() == msg.getConnectType()) {
			long sessionId = msg.getSendUserId();
			sendHeartBeatMessage(sessionId);
		}
		else {
			MessageHandler<?> messageHandler = MessageHandlerFactory.getMessageHandler(msg.getMessageBodyType());
			MessageMapping mapping = MessageMapping.INSTANCE;
			TextMessage textMessage = mapping.sourceToTarget(msg);
			messageHandler.resolveMessage(textMessage);
		}
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		log.debug("channel add {}", ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		log.debug("channel removed: {}", ctx.channel());
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		log.debug("channel Inactive: {}", ctx.channel());
		sessionManager.remove(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LibreErrorEvent event = new LibreErrorEvent();
		event.setErrorType(ErrorType.WEB_SOCKET);
		ErrorUtil.initErrorInfo(cause, event);
		publisher.publishEvent(event);
		log.error("error: {}", event);
		sessionManager.remove(ctx);
		ctx.close();
	}

	private void sendHeartBeatMessage(long sessionId) {
		TextMessageHandler messageHandler = MessageHandlerFactory.getMessageHandler(MessageBodyType.TEXT.getCode());
		messageHandler.sendHeartBeatMessage(sessionId);
	}

}
