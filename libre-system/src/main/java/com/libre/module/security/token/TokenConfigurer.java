package com.libre.module.security.token;


import com.libre.common.security.prop.SecurityProperties;
import com.libre.module.security.service.OnlineUserService;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author zhao.cheng
 */

public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {


    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;

    public TokenConfigurer(SecurityProperties properties,
                           OnlineUserService onlineUserService) {
        this.properties = properties;
        this.onlineUserService = onlineUserService;
    }

    @Override
    public void configure(HttpSecurity http) {
        TokenFilter customFilter = new TokenFilter(properties, onlineUserService);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
