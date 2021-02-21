package com.libre.module.security.token;

import com.libre.module.security.prop.SecurityProperties;
import com.libre.module.security.service.OnlineUserService;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author zhao.cheng
 */

public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;
    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;

    public TokenConfigurer(TokenProvider tokenProvider, SecurityProperties properties, OnlineUserService onlineUserService) {
        this.tokenProvider = tokenProvider;
        this.properties = properties;
        this.onlineUserService = onlineUserService;
    }

    @Override
    public void configure(HttpSecurity http) {
        TokenFilter customFilter = new TokenFilter(tokenProvider, properties, onlineUserService);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
