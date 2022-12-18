package com.libre.framework.system.module.security.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import com.libre.framework.logging.annotation.ApiLog;
import com.libre.framework.logging.support.SysLogType;
import com.libre.framework.system.config.LibreSecurityProperties;
import com.libre.framework.system.module.security.jwt.JwtTokenProvider;
import com.libre.framework.common.security.AuthUser;
import com.libre.framework.system.module.security.pojo.dto.AuthUserDTO;
import com.libre.framework.system.module.security.pojo.dto.UserInfo;
import com.libre.framework.system.module.security.service.JwtTokenService;
import com.libre.framework.system.module.security.service.UserLockService;
import com.libre.framework.system.module.system.pojo.entity.SysMenu;
import com.libre.framework.system.module.system.pojo.vo.MenuVO;
import com.libre.framework.system.module.system.service.SysMenuService;
import com.libre.framework.system.module.system.service.SysUserService;
import com.libre.framework.system.module.system.utils.MenuUtil;
import com.libre.captcha.service.CaptchaService;
import com.libre.captcha.vo.CaptchaVO;
import com.libre.toolkit.result.R;
import com.libre.redis.cache.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Libre
 * @date 2021/7/12 17:54
 */
@Slf4j
@Api(tags = "授权管理")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

	private final LibreSecurityProperties properties;

	private final SysMenuService menuService;

	private final CaptchaService captchaService;

	private final RedisUtils redisUtils;

	private final JwtTokenService jwtTokenService;

	private final JwtTokenProvider jwtTokenProvider;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	private final UserLockService userLockService;

	private final SysUserService sysUserService;

	@GetMapping("/captcha")
	public R<CaptchaVO> captcha() {
		CaptchaVO captchaVO = captchaService.generateBase64Vo(IdWorker.get32UUID());
		return R.data(captchaVO);
	}

	@ApiLog(value = "登录", type = SysLogType.Login)
	@ApiOperation("登录")
	@PostMapping("/token")
	public R<UserInfo> login(@Validated AuthUserDTO authUser, HttpServletRequest request) {
		String password = authUser.getPassword();
		String retryLimitCacheName = properties.getLogin().getRetryLimitCacheName();
		String username = authUser.getUsername();
		retryLimitCacheName = retryLimitCacheName + username;
		Integer retryCount = redisUtils.get(retryLimitCacheName);
		if (null == retryCount) {
			retryCount = 1;
			redisUtils.setEx(retryLimitCacheName, retryCount, properties.getLogin().getRetryLimitTime());
		}
		int retryLimit = properties.getLogin().getRetryLimit();
		if (retryCount > retryLimit) {
			log.warn("username: " + username + " tried to login more than " + retryLimit + " times in period");
			userLockService.updateLockUser(authUser);
			throw new LockedException("登录错误" + retryCount + "次，账号已锁定");
		}
		else {
			redisUtils.incr(retryLimitCacheName);
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				authUser.getUsername(), password);
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.createToken(authentication);
		final AuthUser jwtUserDto = (AuthUser) authentication.getPrincipal();
		// 保存在线信息
		jwtTokenService.save(jwtUserDto, token, request);
		redisUtils.del(retryLimitCacheName);
		UserInfo userInfo = new UserInfo(username, token);
		return R.data(userInfo);
	}

	@ApiOperation("获取用户信息")
	@PostMapping("/userInfo")
	public R<UserInfo> getUserInfo(AuthUser authUser) {
		UserInfo userInfo = sysUserService.findUserInfoByUsername(authUser.getUsername());
		return R.data(userInfo);
	}


	@ApiOperation("退出登录")
	@DeleteMapping(value = "/logout")
	@ApiLog(value = "登出", type = SysLogType.Logout)
	public R<Boolean> logout(HttpServletRequest request) {
		String token = jwtTokenProvider.getToken(request);
		jwtTokenService.removeByToken(token);
		return R.data(Boolean.TRUE);
	}


	@GetMapping("/menus")
	public R<List<MenuVO>> getMenus(AuthUser user) {
		List<SysMenu> menuList = menuService.getMenuListByUsername(user.getUsername());
		return R.data(MenuUtil.transformList(menuList));
	}

}
