package com.libre.admin.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ZC
 * @date 2021/7/11 20:20
 */
@Configuration(proxyBeanMethods = false)
public class LibreSecurityConfiguration extends WebSecurityConfigurerAdapter {
}
