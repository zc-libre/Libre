package com.libre.framework.toolkit.moudle.social.core.websocket.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestTask {

	private final SimpMessagingTemplate simpMessagingTemplate;

	// @Scheduled(fixedRate = 5000)
	public void test() {
		log.info("开始发送数据");
		simpMessagingTemplate.convertAndSend("/topic/reply", "测试数据");
	}

}
