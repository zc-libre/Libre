package com.libre.framework.security.jwt;

import com.google.common.base.Throwables;
import com.libre.boot.toolkit.RequestUtils;
import com.libre.framework.common.security.support.SecurityUtil;
import com.libre.framework.security.auth.SecWebAuthDetailsSource;
import com.libre.framework.security.pojo.dto.AuthUser;
import com.libre.framework.security.pojo.vo.TokenVo;
import com.libre.framework.security.service.UserDetailServiceImpl;
import com.libre.toolkit.core.StringUtil;
import com.libre.toolkit.result.R;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

/**
 * token过滤器
 *
 * @author L.cm
 */
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final JwtTokenStore jwtTokenStore;

	private final JwtTokenService jwtTokenService;

	private final UserDetailServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// 解析 token
		String token = jwtTokenService.getToken(request);
		if (StringUtil.isBlank(token)) {
			chain.doFilter(request, response);
		return;
	}
		TokenVo tokenVo = jwtTokenStore.get(token);
		if (tokenVo == null) {
			// jwt token 解析错误 401
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			RequestUtils.renderJson(response, R.fail("请重新登录"));
			return;
		}
		// 判断 token 是否存在
		String subject;
		try {
			subject = jwtTokenService.getSubject(token);
		}
		catch (JwtException | IllegalArgumentException e) {
			// jwt token 解析错误 401
			logger.error("token解析错误", Throwables.getRootCause(e));
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			RequestUtils.renderJson(response, R.fail("请重新登录"));
			return;
		}
		if (subject != null && SecurityUtil.getAuthentication() == null) {
			AuthUser authUser = userDetailsService.loadUserByUsername(subject);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUser,
					null, authUser.getAuthorities());
			authenticationToken.setDetails(new SecWebAuthDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		chain.doFilter(request, response);
	}

}
