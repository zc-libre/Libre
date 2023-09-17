package com.libre.framework.im.core.codec;

import com.libre.framework.im.core.message.MediaMessage;
import com.libre.framework.im.core.message.TextMessage;
import com.libre.toolkit.json.JsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Libre
 * @Date: 2022/4/30 3:21 AM
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class JacksonMessageDecoder extends MessageToMessageDecoder<WebSocketFrame> {



    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> objects) throws Exception {
        ByteBuf byteBuf = webSocketFrame.content();
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        if (webSocketFrame instanceof TextWebSocketFrame) {
            TextMessage textMessage = JsonUtil.readValue(data, TextMessage.class);
            objects.add(textMessage);
        }
        else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            MediaMessage mediaMessage = JsonUtil.readValue(data, MediaMessage.class);
            objects.add(mediaMessage);
        }

    }
}
