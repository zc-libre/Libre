package com.zclibre.system.module.security.jwt;

import com.zclibre.system.config.LibreSecurityProperties;
import com.zclibre.system.module.security.service.OnlineUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author /
 */
@RequiredArgsConstructor
public class JwtTokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final JwtTokenProvider jwtTokenProvider;

	private final LibreSecurityProperties properties;

	private final OnlineUserService onlineUserService;

	private final UserDetailsService userDetailsService;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Override
	public void configure(HttpSecurity http) {
		JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider, properties, onlineUserService, userDetailsService,
				authenticationManagerBuilder);
		http.addFilterAt(jwtTokenFilter, BasicAuthenticationFilter.class);
	}

}
