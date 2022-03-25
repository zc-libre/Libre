package com.libre.admin.common.config;

import com.libre.admin.module.security.auth.JwtAccessHandler;
import com.libre.admin.module.security.auth.LibreAuthenticationDetailsSource;
import com.libre.admin.module.security.auth.LibreAuthenticationProvider;
import com.libre.admin.module.security.jwt.JwtAuthenticationTokenFilter;
import com.libre.admin.module.security.service.UserDetailServiceImpl;
import com.libre.captcha.service.CaptchaService;
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
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author ZC
 * @date 2021/7/11 20:20
 */
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(LibreSecurityProperties.class)
@Configuration(proxyBeanMethods = false)
public class LibreSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtAccessHandler authHandler;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    private final LibreAuthenticationDetailsSource authDetailsSource;
    private final CaptchaService captchaService;
    private final LibreSecurityProperties properties;
    private final ApplicationContext applicationContext;

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        // 去除 ROLE_ 前缀
        return new GrantedAuthorityDefaults("");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers(
                        "/src/main/resources/favicon.ico",
                        "/error",
                        "/static/**",
                        "/webjars*",
                        "/webjars/**",
                        "/auth/captcha",
                        "/auth/public-key",
                        "/upload/**",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/doc.html")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(authHandler);

        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/auth/token")
                .failureHandler(authHandler)
                .successHandler(authHandler)
                .authenticationDetailsSource(authDetailsSource)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(false)
                .logoutSuccessHandler(authHandler)
                .logoutSuccessUrl("/");

        // jwt 认证的 filter
        http.addFilterAt(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class);

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers(properties.getPermitAll().toArray(new String[0]));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public LibreAuthenticationProvider authProvider(PasswordEncoder passwordEncoder,
                                                    UserDetailServiceImpl userDetailsService,
                                                    CacheManager cacheManager) {
        final LibreAuthenticationProvider authProvider = new LibreAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setUserDetailsPasswordService(userDetailsService);
        authProvider.setProperties(properties);
        authProvider.setCacheManager(cacheManager);
        authProvider.setPasswordEncoder(passwordEncoder);
        authProvider.setCaptchaService(captchaService);
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(applicationContext.getBean(LibreAuthenticationProvider.class));
        auth.eraseCredentials(false);
    }
}
