package com.libre.framework.security.oauth2.support.core;

import com.libre.framework.security.oauth2.support.handler.FormAuthenticationFailureHandler;
import com.libre.framework.security.oauth2.support.handler.SsoLogoutSuccessHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

/**
 * @author lengleng
 * @data 2022-06-04
 *
 * 基于授权码模式 统一认证登录 spring security & sas 都可以使用 所以抽取成 HttpConfigurer
 */
public final class FormIdentityLoginConfigurer
		extends AbstractHttpConfigurer<FormIdentityLoginConfigurer, HttpSecurity> {

	@Override
	public void init(HttpSecurity http) throws Exception {
		http.formLogin(formLogin -> {
			formLogin.loginPage("/");
			formLogin.loginProcessingUrl("/api/auth/token");
			formLogin.failureHandler(new FormAuthenticationFailureHandler());
		}).logout() // SSO登出成功处理
				.logoutUrl("/api/auth/logout").logoutSuccessHandler(new SsoLogoutSuccessHandler())
				.deleteCookies("JSESSIONID").invalidateHttpSession(true).and().csrf().disable();
	}

}
