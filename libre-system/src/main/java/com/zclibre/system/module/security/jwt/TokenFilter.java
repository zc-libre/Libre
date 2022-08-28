package com.zclibre.system.module.security.jwt;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import com.libre.boot.toolkit.RequestUtils;
import com.libre.toolkit.result.R;
import com.zclibre.system.config.LibreSecurityProperties;
import com.zclibre.system.module.security.constant.SecurityConstant;
import com.zclibre.system.module.security.service.OnlineUserService;
import com.zclibre.system.module.security.service.dto.AuthUser;
import com.zclibre.system.module.security.service.dto.OnlineUserDTO;
import com.libre.toolkit.core.StringUtil;
import com.zclibre.system.module.security.utils.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author /
 */
public class TokenFilter extends OncePerRequestFilter {

	private static final Logger log = LoggerFactory.getLogger(TokenFilter.class);

	public static final String TOKEN_PREFIX = "Bearer ";

	private final TokenProvider tokenProvider;

	private final LibreSecurityProperties properties;

	private final OnlineUserService onlineUserService;

	private final UserDetailsService userDetailsService;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	public TokenFilter(TokenProvider tokenProvider, LibreSecurityProperties properties,
					   OnlineUserService onlineUserService, UserDetailsService userDetailsService, AuthenticationManagerBuilder authenticationManagerBuilder) {
		this.tokenProvider = tokenProvider;
		this.properties = properties;
		this.onlineUserService = onlineUserService;

		this.userDetailsService = userDetailsService;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String token = resolveToken(request);
		// 对于 Token 为空的不需要去查 Redis
		if (StringUtil.isNotBlank(token)) {
			OnlineUserDTO onlineUserDto = null;
			try {
				onlineUserDto = onlineUserService.getOne(token);
			}
			catch (Exception e) {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				RequestUtils.renderJson(response, R.fail("请重新登录"));
			}
			if (onlineUserDto != null && SecurityUtil.getAuthentication() == null) {
				Authentication authentication = tokenProvider.getAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				tokenProvider.checkRenewal(token);
			}
		}
		filterChain.doFilter(request, response);
	}

	/**
	 * 初步检测Token
	 * @param request /
	 * @return /
	 */
	private String resolveToken(HttpServletRequest request) {
		LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
		String bearerToken = request.getHeader(jwtToken.getHeader());
		if (StringUtils.hasText(bearerToken)) {
			if (bearerToken.startsWith(TOKEN_PREFIX)) {
				// 去掉令牌前缀
				return bearerToken.replace(TOKEN_PREFIX, StringPool.EMPTY);
			}
			else {
				log.error("非法Token：{}", bearerToken);
			}
		}
		return null;
	}

}
