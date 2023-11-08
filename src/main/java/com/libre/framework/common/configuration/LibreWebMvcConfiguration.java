package com.libre.framework.common.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author Libre
 * @date 2021/7/12 16:02
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LibreFileProperties.class)
@RequiredArgsConstructor
public class LibreWebMvcConfiguration implements WebMvcConfigurer {

	private final LibreFileProperties properties;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new AuthUserArgumentResolver());
		argumentResolvers.add(new PageArgumentResolver());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String pathUrl = "file:" + properties.getUploadPath().replace("\\", "/");
		registry.addResourceHandler("/file/**").addResourceLocations(pathUrl);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOriginPatterns("*")
			.allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS")
			.allowedHeaders("*")
			.exposedHeaders("access-control-allow-headers", "access-control-allow-methods",
					"access-control-allow-origin", "access-control-max-age", "X-Frame-Options")
			.maxAge(3600);
	}

}
