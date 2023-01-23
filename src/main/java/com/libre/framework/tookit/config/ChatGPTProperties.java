package com.libre.framework.tookit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Libre
 * @Date: 2023/1/23 5:12 PM
 */
@Data
@ConfigurationProperties(prefix = "libre.chat")
public class ChatGPTProperties {

    private String url = "https://api.openai.com/v1/completions";

    private String token = "Bearer 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";

}
