package com.libre.framework.system.config;

import com.libre.framework.system.module.security.auth.SecAuthHandler;
import com.libre.framework.system.module.security.auth.SecAuthenticationProvider;
import com.libre.framework.system.module.security.auth.SecWebAuthDetailsSource;
import com.libre.framework.system.module.security.jwt.JwtAuthenticationTokenFilter;
import com.libre.framework.system.module.security.service.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Spring Security 权限控制
 *
 */
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LibreSecurityProperties.class)
public class LibreSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailServiceImpl userDetailsService;

	private final SecAuthHandler authHandler;

	private final SecWebAuthDetailsSource authDetailsSource;

	private final LibreSecurityProperties properties;

	private final CacheManager cacheManager;

	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	private final ApplicationContext applicationContext;

	@Override
	public void configure(WebSecurity web) {
		// @formatter:off
		web.ignoring()
			.antMatchers(HttpMethod.OPTIONS, "/**")
			.antMatchers(properties.getPermitAll().toArray(new String[0]));
		// @formatter:on
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		// 关闭 csrf、iframe、session
		http.csrf()
			.disable()
			.headers()
			.frameOptions()
			.disable()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling()
			.accessDeniedHandler(authHandler);

		http.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/api/auth/token")
			.failureHandler(authHandler)
			.successHandler(authHandler)
			.authenticationDetailsSource(authDetailsSource)
			.permitAll()
			.and()
			.logout()
			.logoutUrl("/api/auth/logout")
			.clearAuthentication(false)
			.logoutSuccessHandler(authHandler)
			.logoutSuccessUrl("/");

		// jwt 认证的 filter
		http.addFilterAt(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class);
		// @formatter:on
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(applicationContext.getBean(SecAuthenticationProvider.class));
		auth.eraseCredentials(false);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public SecAuthenticationProvider authProvider() {
		final SecAuthenticationProvider authProvider = new SecAuthenticationProvider();
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

}
