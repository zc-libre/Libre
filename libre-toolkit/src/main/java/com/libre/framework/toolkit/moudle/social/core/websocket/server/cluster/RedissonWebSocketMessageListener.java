
package com.libre.framework.toolkit.moudle.social.core.websocket.server.cluster;

import com.libre.framework.toolkit.moudle.social.core.websocket.common.message.WsMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.constant.MicaConstant;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.core.env.Environment;

/**
 * websocket 集群的消息监听
 *
 * @author L.cm
 */
@Slf4j
@RequiredArgsConstructor
public class RedissonWebSocketMessageListener implements SmartInitializingSingleton, MessageListener<WsMessage> {

    private final Environment environment;

    private final RedissonClient redisson;

    private final ClusterWebSocketProperties properties;

    private final ClusterWebSocketSender webSocketSender;

    @Override
    public void onMessage(CharSequence charSequence, WsMessage wsMessage) {
        log.info("Redisson sub onMessage channel:{}", charSequence);
        webSocketSender.send(wsMessage);
    }

    @Override
    public void afterSingletonsInstantiated() {
        // 拼接 topic name
        String redisSubTopic = getRedisSubTopic(environment, properties);
        RTopic topic = redisson.getTopic(redisSubTopic);
        topic.addListener(WsMessage.class, this);
    }

    private static String getRedisSubTopic(Environment environment, ClusterWebSocketProperties properties) {
        return properties.getRedisSubTopicPrefix() + environment.getProperty(MicaConstant.SPRING_APP_NAME_KEY);
    }
}
