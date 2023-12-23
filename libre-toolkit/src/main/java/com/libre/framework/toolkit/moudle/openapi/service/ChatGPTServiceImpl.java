package com.libre.framework.toolkit.moudle.openapi.service;

import com.google.common.collect.Lists;
import com.libre.framework.toolkit.config.ChatGPTProperties;
import com.libre.framework.toolkit.moudle.openapi.pojo.ChatRequest;
import com.libre.framework.toolkit.moudle.openapi.pojo.ChatResponse;
import com.libre.toolkit.exception.LibreException;
import lombok.RequiredArgsConstructor;
import net.dreamlu.mica.http.HttpRequest;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MimeTypeUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Libre
 * @Date: 2023/1/23 5:13 PM
 */
@Component
@RequiredArgsConstructor
public class ChatGPTServiceImpl implements ChatGPTService, SmartInitializingSingleton {

	private final Map<String, String> headers = new HashMap<>();

	private final ChatGPTProperties properties;

	@Override
	public String request(String prompt) {
		ChatRequest chatRequest = new ChatRequest();
		List<ChatRequest.Message> messages = Lists.newArrayList();
		ChatRequest.Message message = new ChatRequest.Message();
		message.setRole("user");
		message.setContent(prompt);
		messages.add(message);
		chatRequest.setMessages(messages);
		return request(chatRequest);
	}

	@Override
	public String request(ChatRequest request) {
		ChatResponse response = HttpRequest.post(properties.getUrl())
			.readTimeout(Duration.ofMinutes(2))
			.writeTimeout(Duration.ofMinutes(2))
			.addHeader(headers)
			.useSlf4jLog()
			.bodyJson(request)
			.execute()
			.asValue(ChatResponse.class);
		List<ChatResponse.ChoicesItem> choices = response.getChoices();
		if (CollectionUtils.isEmpty(choices)) {
			throw new LibreException("请求失败, 请重新请求");
		}
		ChatResponse.ChoicesItem choicesItem = choices.get(0);
		ChatResponse.ResponseMessage message = choicesItem.getMessage();
		return message.getContent();
	}

	@Override
	public void afterSingletonsInstantiated() {
		headers.put("Authorization", properties.getToken());
		headers.put("Content-Type", MimeTypeUtils.APPLICATION_JSON_VALUE);
	}

}
