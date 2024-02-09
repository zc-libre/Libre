package com.libre.framework.system.security.oauth2;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author bty
 * @date 2023/2/6
 * @since 17
 **/

public class BearerTokenAuthenticationFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(BearerTokenAuthenticationFilter.class);

	private final AuthenticationEntryPoint entrypoint;

	private final BearerTokenResolver bearerTokenResolver;

	private final AuthenticationManager authenticationManager;

	private final AuthenticationFailureHandler failureHandler;

	private SecurityContextRepository securityContextRepository = new NullSecurityContextRepository();

	private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();

	public BearerTokenAuthenticationFilter(AuthenticationEntryPoint entrypoint, BearerTokenResolver bearerTokenResolver,
			AuthenticationManager authenticationManager, AuthenticationFailureHandler failureHandler) {
		this.entrypoint = entrypoint;
		this.bearerTokenResolver = bearerTokenResolver;
		this.authenticationManager = authenticationManager;
		this.failureHandler = failureHandler;
	}

	public void setSecurityContextRepository(SecurityContextRepository securityContextRepository) {
		this.securityContextRepository = securityContextRepository;
	}

	public void setAuthenticationDetailsSource(
			AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource) {
		this.authenticationDetailsSource = authenticationDetailsSource;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 登录以 /login 或 /oauth2开头
		if (request.getServletPath().startsWith("/login") || request.getServletPath().startsWith("/oauth2")) {
			logger.info("skip token authentication for path {}", request.getServletPath());
			filterChain.doFilter(request, response);
			return;
		}

		String token;

		try {
			token = this.bearerTokenResolver.resolve(request);
		}
		catch (OAuth2AuthenticationException invalid) {
			logger.trace("Sending to authentication entry point since failed to resolve bearer token", invalid);
			this.entrypoint.commence(request, response, invalid);
			return;
		}

		if (token == null) {
			logger.info("bearer token is null");
			filterChain.doFilter(request, response);
			return;
		}

		JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(token);
		jwtAuthenticationToken.setDetails(this.authenticationDetailsSource.buildDetails(request));

		try {
			Authentication authenticationResult = authenticationManager.authenticate(jwtAuthenticationToken);
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			context.setAuthentication(authenticationResult);
			SecurityContextHolder.setContext(context);
			this.securityContextRepository.saveContext(context, request, response);
			logger.info("SecurityContext Authentication:{}", authenticationResult);
			filterChain.doFilter(request, response);
		}
		catch (AuthenticationException e) {
			SecurityContextHolder.clearContext();
			this.failureHandler.onAuthenticationFailure(request, response, e);
		}

	}

}
