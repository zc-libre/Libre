package com.libre.framework.security.controller;

import com.libre.framework.common.security.JwtUser;
import com.libre.framework.common.security.RoleInfo;
import com.libre.framework.common.security.AuthUser;
import com.libre.framework.system.constant.UserConstants;
import com.libre.framework.system.pojo.entity.SysMenu;
import com.libre.framework.system.pojo.vo.MenuVO;
import com.libre.framework.system.service.SysMenuService;
import com.libre.framework.system.service.SysUserService;
import com.libre.framework.system.toolkit.MenuUtil;
import com.libre.toolkit.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

	private final SysUserService sysUserService;

	@ApiOperation("获取用户信息")
	@GetMapping("/info")
	public R<JwtUser> getUserInfo(AuthUser authUser) {
		JwtUser jwtUser = authUser.toJwtUser();
		return R.data(jwtUser);
	}

	@GetMapping("/menus")
	public R<List<MenuVO>> getMenus(AuthUser user) { // 1. 超级管理员
		if (UserConstants.IS_ADMIN_YES.equals(user.getIsAdmin())) {
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
