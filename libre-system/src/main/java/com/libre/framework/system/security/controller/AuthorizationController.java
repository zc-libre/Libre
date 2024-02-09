package com.libre.framework.system.security.controller;

import com.libre.framework.common.security.constant.SecurityConstant;
import com.libre.framework.common.security.dto.AuthUser;
import com.libre.framework.common.security.dto.JwtUser;
import com.libre.framework.common.security.dto.RoleInfo;
import com.libre.framework.common.security.support.SecurityUtil;
import com.libre.framework.system.pojo.entity.SysMenu;
import com.libre.framework.system.pojo.vo.MenuVO;
import com.libre.framework.system.security.auth.LibreWebAuthDetailsSource;
import com.libre.framework.system.security.auth.LibreWebAuthenticationDetails;
import com.libre.framework.system.security.configuration.LibreSecurityProperties;
import com.libre.framework.system.security.jwt.JwtTokenService;
import com.libre.framework.system.security.jwt.JwtTokenStore;
import com.libre.framework.system.security.pojo.dto.AuthUserDTO;
import com.libre.framework.system.service.SysMenuService;
import com.libre.framework.system.toolkit.MenuUtil;
import com.libre.framework.toolkit.moudle.log.annotation.ApiLog;
import com.libre.framework.toolkit.moudle.log.support.SysLogType;
import com.libre.toolkit.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Libre
 * @date 2021/7/12 17:54
 */
@Slf4j
@Api(tags = "授权管理")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthorizationController {

	private final SysMenuService menuService;

	private final JwtTokenService jwtTokenService;

	private final LibreSecurityProperties securityProperties;

	private final JwtTokenStore jwtTokenStore;

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	private final LibreWebAuthDetailsSource webAuthDetailsSource;

	@PostMapping("token")
	@ApiLog(value = "登录成功", type = SysLogType.Login)
	public R<Object> login(AuthUserDTO loginUser, HttpServletRequest request) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginUser.getUsername(), loginUser.getPassword());
		WebAuthenticationDetails webAuthenticationDetails = webAuthDetailsSource.buildDetails(request);
		authenticationToken.setDetails(webAuthenticationDetails);

		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		LibreWebAuthenticationDetails details = (LibreWebAuthenticationDetails) authentication.getDetails();
		authenticationToken.setDetails(details);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// 用户信息
		AuthUser authUser = SecurityUtil.getUser(authentication);
		Date now = new Date();
		// 令牌有效期
		LibreSecurityProperties.JwtToken jwtToken = securityProperties.getJwtToken();
		Duration expireTime = details.isRememberMe() ? jwtToken.getRememberMeTime() : jwtToken.getExpireTime();
		if (Objects.isNull(authUser)) {
			throw new BadCredentialsException("用户不存在");
		}
		String token = jwtTokenService.createToken(authUser.getUsername(), now, expireTime);
		// token 管理
		jwtTokenStore.save(request, authUser, token, expireTime);

		JwtUser jwtUser = authUser.toJwtUser();
		jwtUser.setToken(token);
		return R.data(jwtUser);
	}


	@ApiOperation("获取用户信息")
	@GetMapping("/info")
	public R<JwtUser> getUserInfo(AuthUser authUser) {
		JwtUser jwtUser = authUser.toJwtUser();
		return R.data(jwtUser);
	}


	@GetMapping("/menus")
	public R<List<MenuVO>> getMenus(AuthUser user) { // 1. 超级管理员
		if (SecurityConstant.IS_ADMIN_YES.equals(user.getIsAdmin())) {
			List<SysMenu> menuList = menuService.getAllMenu();
			return R.data(MenuUtil.transformList(menuList));
		}
		// 2. 其他用户
		List<RoleInfo> roleList = user.getRoleList();
		if (roleList == null || roleList.isEmpty()) {
			return R.data(Collections.emptyList());
		}
		Set<Long> roleIds = roleList.stream().map(RoleInfo::getId).collect(Collectors.toSet());
		List<SysMenu> menuList = menuService.getNavByRoleIds(roleIds);
		return R.data(MenuUtil.transformList(menuList));
	}

}
