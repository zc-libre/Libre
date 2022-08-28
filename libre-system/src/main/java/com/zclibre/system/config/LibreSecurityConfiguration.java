package com.zclibre.system.config;

import com.zclibre.system.module.security.auth.JwtAccessDeniedHandler;
import com.zclibre.system.module.security.auth.JwtAuthenticationEntryPoint;
import com.zclibre.system.module.security.jwt.TokenConfigurer;
import com.zclibre.system.module.security.jwt.TokenProvider;
import com.zclibre.system.module.security.service.OnlineUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;

/**
 * @author Libre
 * @date 2021/7/11 20:20
 */
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(LibreSecurityProperties.class)
@Configuration(proxyBeanMethods = false)
public class LibreSecurityConfiguration {

	private final CorsFilter corsFilter;

	private final JwtAuthenticationEntryPoint authenticationErrorHandler;

	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

	private final LibreSecurityProperties properties;

	private final ApplicationContext applicationContext;

	private final TokenProvider tokenProvider;

	private final OnlineUserService onlineUserService;

	private final UserDetailsService userDetailsService;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Bean
	GrantedAuthorityDefaults grantedAuthorityDefaults() {
		return new GrantedAuthorityDefaults("");
	}

	@Bean
	SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		// 搜寻匿名标记 url： @AnonymousAccess
		RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) applicationContext
				.getBean("requestMappingHandlerMapping");
		Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
		// 获取匿名标记
		// Map<String, Set<String>> anonymousUrls = getAnonymousUrl(handlerMethodMap);
		List<String> permitAll = properties.getPermitAll();

		http.csrf().disable().addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling().authenticationEntryPoint(authenticationErrorHandler)
				.accessDeniedHandler(jwtAccessDeniedHandler);

		http.headers().frameOptions().disable();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/webSocket/**")
				.permitAll().antMatchers("/swagger-ui.html").permitAll().antMatchers("/swagger-resources/**")
				.permitAll().antMatchers("/webjars/**").permitAll().antMatchers("/*/api-docs").permitAll()
				.antMatchers("/avatar/**").permitAll().antMatchers("/file/**").permitAll().antMatchers("/druid/**")
				.permitAll().antMatchers(permitAll.toArray(new String[0])).permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and()
				.apply(securityConfigurerAdapter());
		return http.build();
	}

	private TokenConfigurer securityConfigurerAdapter() {
		return new TokenConfigurer(tokenProvider, properties, onlineUserService, userDetailsService,
				authenticationManagerBuilder);
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
