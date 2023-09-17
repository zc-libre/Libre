package com.libre.framework.security.oauth2.config;

import com.libre.framework.security.oauth2.support.core.FormIdentityLoginConfigurer;
import com.libre.framework.security.oauth2.support.core.OAuth2DaoAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 服务安全相关配置
 *
 * @author lengleng
 * @date 2022/1/12
 */
@EnableWebSecurity
public class WebSecurityConfiguration {

	/**
	 * spring security 默认的安全策略
	 * @param http security注入点
	 * @return SecurityFilterChain
	 * @throws Exception
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers("/token/*").permitAll()// 开放自定义的部分端点
				.anyRequest().authenticated())
				.headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))// 避免iframe同源无法登录
				.apply(new FormIdentityLoginConfigurer()); // 表单登录个性化
		// 处理 UsernamePasswordAuthenticationToken
		http.authenticationProvider(new OAuth2DaoAuthenticationProvider());
		return http.build();
	}

	/**
	 * 暴露静态资源
	 *
	 * https://github.com/spring-projects/spring-security/issues/10938
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	@Order(0)
	SecurityFilterChain resources(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((matchers) -> matchers.requestMatchers("/actuator/**", "/css/**", "/error"))
				.authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
				.requestCache(RequestCacheConfigurer::disable).securityContext(AbstractHttpConfigurer::disable)
				.sessionManagement(AbstractHttpConfigurer::disable);
		return http.build();
	}

}
