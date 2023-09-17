package com.libre.framework.im.core.server;

import com.libre.framework.im.core.codec.ProtobufMessageDecoder;
import com.libre.framework.im.core.codec.ProtobufMessageEncoder;
import com.libre.framework.im.config.WebsocketServerProperties;
import com.libre.framework.im.core.handler.WebSocketJwtTokenHandler;
import com.libre.framework.im.core.handler.WebSocketChannelInitializer;
import com.libre.framework.im.core.handler.WebSocketMessageHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Component;

/**
 * @author ZC
 * @date 2021/7/31 22:54
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LibreWebsocketServer implements ApplicationRunner {

	private final ProtobufMessageDecoder protobufMessageDecoder;

	private final ProtobufMessageEncoder protobufMessageEncoder;

	private final WebsocketServerProperties properties;

	private final WebSocketJwtTokenHandler webSocketJwtTokenHandler;

	private final WebSocketMessageHandler webSocketMessageHandler;

	public void run() {
		Integer port = properties.getPort();
		NioEventLoopGroup boss = new NioEventLoopGroup();
		NioEventLoopGroup worker = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();

		try {
			bootstrap.group(boss, worker)
					.channel(NioServerSocketChannel.class)
					.localAddress(port)
					.childHandler(new WebSocketChannelInitializer(protobufMessageEncoder, protobufMessageDecoder,
							properties, webSocketMessageHandler, webSocketJwtTokenHandler))
					.option(ChannelOption.SO_BACKLOG, 128)
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture channelFuture = bootstrap.bind().addListener((ChannelFutureListener) future -> {
				if (future.isSuccess()) {
					log.info("websocket server started on {}", port);
				}
				else {
					log.error("Cannot start server, follows exception: {}", future.cause().getMessage());
				}
			});
			channelFuture.channel().closeFuture().sync();
		}
		catch (InterruptedException e) {
			log.error("websocket server error: {}", NestedExceptionUtils.buildMessage(e.getMessage(), e));
		}
		finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.run();
	}
}
