package com.libre.framework.system.security.auth;

import com.google.common.base.Throwables;
import com.libre.boot.exception.BusinessException;
import com.libre.boot.toolkit.RequestUtils;
import com.libre.framework.system.security.configuration.LibreSecurityProperties;
import com.libre.framework.system.security.jwt.JwtTokenService;
import com.libre.framework.system.security.jwt.JwtTokenStore;
import com.libre.framework.toolkit.moudle.log.support.SysLogConstant;
import com.libre.framework.toolkit.moudle.log.support.SysLogEvent;
import com.libre.framework.toolkit.moudle.log.support.SysLogType;
import com.libre.framework.toolkit.moudle.log.support.SysLogUtil;
import com.libre.toolkit.core.StringUtil;
import com.libre.toolkit.result.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 成功、失败的处理器
 *
 * @author L.cm
 */
@Slf4j
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class LibreAuthHandler extends AccessDeniedHandlerImpl
		implements AuthenticationFailureHandler, LogoutSuccessHandler {

	private final JwtTokenService tokenService;

	private final JwtTokenStore tokenStore;

	private final LibreSecurityProperties properties;

	private final ApplicationEventPublisher publisher;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) {
		if (response.isCommitted()) {
			return;
		}
		// 没有权限 403
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		RequestUtils.renderJson(response, R.fail("没有权限访问"));
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) {
		log.error("登录失败：", Throwables.getRootCause(e));
		// 转换异常并且抛出给统一异常工具处理
		throw new BusinessException(e.getMessage());
	}

//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) {
//		LibreWebAuthenticationDetails details = (LibreWebAuthenticationDetails) authentication.getDetails();
//		// 用户信息
//		AuthUser authUser = SecurityUtil.getUser(authentication);
//		Date now = new Date();
//		// 令牌有效期
//		LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
//		Duration expireTime = details.isRememberMe() ? jwtToken.getRememberMeTime() : jwtToken.getExpireTime();
//		if (Objects.isNull(authUser)) {
//			throw new BadCredentialsException("用户不存在");
//		}
//		String token = tokenService.createToken(authUser, now, expireTime);
//		// token 管理
//		tokenStore.save(request, authUser, token, expireTime);
//
//		JwtUser jwtUser = authUser.toJwtUser();
//		jwtUser.setToken(token);
//
//		RequestUtils.renderJson(response, R.data(jwtUser));
//		// 记录登录日志
//		SysLogEvent event = SysLogUtil.buildSysLogEvent(SysLogType.Login);
//
//		event.setDescription("登录成功");
//		event.setSuccess(SysLogConstant.SUCCESS);
//		// 发送 spring event 事件
//		publisher.publishEvent(event);
//	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		String token = tokenService.getToken(request);
		// 删除 token
		if (StringUtil.isBlank(token)) {
			log.warn("token为空, {}",request.getRequestURI());
			return;
		}
		tokenStore.removeByToken(token);
		// 记录登出日志
		SysLogEvent event = SysLogUtil.buildSysLogEvent(SysLogType.Logout);
		// 从 token 中解析出登陆用户，此时 authentication 已经清空了
		// token 有超时解析错误等问题
		try {
			event.setUsername(tokenService.getSubject(token));
		}
		catch (Throwable e) {
			log.error(e.getMessage());
		}
		event.setDescription("登出成功");
		event.setSuccess(SysLogConstant.SUCCESS);
		// event.setRequestTime(getRequestTime(request));
		// 发送 spring event 事件
		publisher.publishEvent(event);
	}
}
