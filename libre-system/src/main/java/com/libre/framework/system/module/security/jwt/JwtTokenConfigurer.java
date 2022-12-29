package com.libre.framework.system.module.security.jwt;

import com.libre.framework.system.config.LibreSecurityProperties;
import com.libre.framework.system.module.security.service.JwtTokenService;
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

	private final JwtTokenService jwtTokenService;

	private final UserDetailsService userDetailsService;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Override
	public void configure(HttpSecurity http) {
		JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter(jwtTokenProvider,
				properties, jwtTokenService, userDetailsService, authenticationManagerBuilder);
		http.addFilterAt(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class);
	}

}
