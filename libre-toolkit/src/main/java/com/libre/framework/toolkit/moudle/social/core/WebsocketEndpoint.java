package com.libre.framework.toolkit.moudle.social.core;

import com.libre.boot.exception.BusinessException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebsocketEndpoint {

    private final SimpMessagingTemplate messagingTemplate;

    public WebsocketEndpoint(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    public void processMessageFromClient(@Payload String message, SimpMessageHeaderAccessor headerAccessor) {
        // 获取消息发送者
        Principal principal = headerAccessor.getUser();
        // 理论上握手成功之后就不会为 null，但是还是建议做一下判断
        if (principal == null) {
             throw new BusinessException("用户为空");
        }
        // 获取消息发送的账号id
        String accountId = principal.getName();
        // 回消息给某个用户
        messagingTemplate.convertAndSendToUser(accountId, "/topic/reply", message);
    }
}
