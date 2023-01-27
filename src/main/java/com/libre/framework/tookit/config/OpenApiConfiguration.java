package com.libre.framework.tookit.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Libre
 * @Date: 2023/1/23 5:12 PM
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ChatGPTProperties.class)
public class OpenApiConfiguration {


}
