package com.libre.framework.system.security.configuration;

import com.libre.framework.system.security.auth.LibreAuthHandler;
import com.libre.framework.system.security.auth.LibreAuthenticationProvider;
import com.libre.framework.system.security.jwt.JwtAuthenticationEntryPoint;
import com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter;
import com.libre.framework.system.security.oauth2.*;
import com.libre.framework.system.security.service.UserDetailServiceImpl;
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
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Spring Security 权限控制
 *
 */
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(LibreSecurityProperties.class)
public class LibreSecurityConfiguration implements SmartInitializingSingleton {

	private final UserDetailServiceImpl userDetailsService;

	private final LibreAuthHandler authHandler;

	private final LibreSecurityProperties properties;

	private final CacheManager cacheManager;

	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	private final ApplicationContext applicationContext;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	private final RedisOauth2AuthorizationRequestRepository redisOauth2AuthorizationRequestRepository;

	private final Oauth2AuthenticationSuccessHandler oauth2AuthenticationSuccessHandler;

	private final JwtAuthenticationManager jwtAuthenticationManager;

	private final BearerTokenResolver bearerTokenResolver;

	@Bean
	GrantedAuthorityDefaults grantedAuthorityDefaults() {
		return new GrantedAuthorityDefaults("");
	}

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.csrf(AbstractHttpConfigurer::disable)
			.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(request -> {
				request.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
				request.requestMatchers(properties.getPermitAll().toArray(new String[0])).permitAll();
				request.anyRequest().authenticated();
			})
			.exceptionHandling(exception -> exception.accessDeniedHandler(authHandler)
					.authenticationEntryPoint(jwtAuthenticationEntryPoint));

		http.formLogin(AbstractHttpConfigurer::disable)
				.authenticationProvider(authProvider())
			    .logout(logout -> logout.logoutUrl("/api/auth/logout")
					.clearAuthentication(true)
					.logoutSuccessHandler(authHandler));

		// @formatter:on
		// jwt 认证的 filter
		http.addFilterAt(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class);

		http.oauth2Login(oauth2 -> oauth2.successHandler(oauth2AuthenticationSuccessHandler)
			.failureHandler(authHandler)
			.authorizationEndpoint(authorization -> authorization
				.authorizationRequestRepository(redisOauth2AuthorizationRequestRepository))
			.redirectionEndpoint(redirect -> redirect.baseUri("/login/oauth2/code/*")))
		// .tokenEndpoint(token -> token.accessTokenResponseClient())
		// .userInfoEndpoint(user -> user.userService())
		// .authorizedClientService());
		;

		http.addFilterBefore(new BearerTokenAuthenticationFilter(jwtAuthenticationEntryPoint, bearerTokenResolver,
				jwtAuthenticationManager, authHandler), OAuth2AuthorizationRequestRedirectFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public LibreAuthenticationProvider authProvider() {
		LibreAuthenticationProvider authProvider = new LibreAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setUserDetailsPasswordService(userDetailsService);

		authProvider.setSecurityProperties(properties);
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
