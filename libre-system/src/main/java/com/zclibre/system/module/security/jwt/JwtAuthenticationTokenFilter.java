package com.zclibre.system.module.security.jwt;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import com.libre.boot.toolkit.RequestUtils;
import com.libre.toolkit.result.R;
import com.zclibre.system.config.LibreSecurityProperties;
import com.zclibre.system.module.security.service.JwtTokenService;
import com.zclibre.system.module.security.pojo.dto.OnlineUserDTO;
import com.libre.toolkit.core.StringUtil;
import com.zclibre.system.module.security.utils.SecurityUtil;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author /
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

	public static final String TOKEN_PREFIX = "Bearer ";

	private final JwtTokenProvider jwtTokenProvider;

	private final LibreSecurityProperties properties;

	private final JwtTokenService jwtTokenService;

	private final UserDetailsService userDetailsService;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	public JwtAuthenticationTokenFilter(JwtTokenProvider jwtTokenProvider, LibreSecurityProperties properties,
										JwtTokenService jwtTokenService, UserDetailsService userDetailsService, AuthenticationManagerBuilder authenticationManagerBuilder) {
		this.jwtTokenProvider = jwtTokenProvider;
		this.properties = properties;
		this.jwtTokenService = jwtTokenService;
		this.userDetailsService = userDetailsService;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
	}

	@Override
	protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {

		String token = resolveToken(request);
		// 对于 Token 为空的不需要去查 Redis
		if (StringUtil.isNotBlank(token)) {
			OnlineUserDTO onlineUserDto = null;
			try {
				onlineUserDto = jwtTokenService.getOne(token);
			}
			catch (Exception e) {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				RequestUtils.renderJson(response, R.fail("请重新登录"));
			}
			if (onlineUserDto != null && SecurityUtil.getAuthentication() == null) {
				Authentication authentication = jwtTokenProvider.getAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				jwtTokenProvider.checkRenewal(token);
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
