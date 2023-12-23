package com.libre.framework.security.config;

import com.libre.framework.security.auth.LibreAuthHandler;
import com.libre.framework.security.auth.LibreAuthenticationProvider;
import com.libre.framework.security.auth.LibreWebAuthDetailsSource;
import com.libre.framework.security.jwt.JwtAuthenticationTokenFilter;
import com.libre.framework.security.service.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Spring Security 权限控制
 *
 */
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LibreSecurityProperties.class)
public class LibreSecurityConfiguration implements SmartInitializingSingleton {

	private final UserDetailServiceImpl userDetailsService;

	private final LibreAuthHandler authHandler;

	private final LibreWebAuthDetailsSource authDetailsSource;

	private final LibreSecurityProperties properties;

	private final CacheManager cacheManager;

	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	private final ApplicationContext applicationContext;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Bean
	GrantedAuthorityDefaults grantedAuthorityDefaults() {
		return new GrantedAuthorityDefaults("");
	}

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
			.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(request -> {
				request.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
				request.requestMatchers(properties.getPermitAll().toArray(new String[0])).permitAll();
				request.anyRequest().authenticated();
			})
			.exceptionHandling(exception -> exception.accessDeniedHandler(authHandler));

		http.formLogin(login -> login.loginPage("/")
			.loginProcessingUrl("/api/auth/token")
			.failureHandler(authHandler)
			.successHandler(authHandler)
			.authenticationDetailsSource(authDetailsSource)
			.permitAll())
			.logout(logout -> logout.logoutUrl("/api/auth/logout")
				.clearAuthentication(true)
				.logoutSuccessHandler(authHandler)
				.logoutSuccessUrl("/"));

		// jwt 认证的 filter
		http.addFilterAt(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class);
		// @formatter:on
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public LibreAuthenticationProvider authProvider() {
		final LibreAuthenticationProvider authProvider = new LibreAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setUserDetailsPasswordService(userDetailsService);

		authProvider.setMicaSecurityProperties(properties);
		authProvider.setCacheManager(cacheManager);
		authProvider.setPasswordEncoder(applicationContext.getBean(PasswordEncoder.class));
		return authProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	public void afterSingletonsInstantiated() {
		authenticationManagerBuilder
			.authenticationProvider(applicationContext.getBean(LibreAuthenticationProvider.class));
		authenticationManagerBuilder.eraseCredentials(false);
	}

}
