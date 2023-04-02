package com.libre.framework.security.controller;

import com.libre.framework.common.security.constant.SecurityConstant;
import com.libre.framework.common.security.dto.JwtUser;
import com.libre.framework.common.security.dto.RoleInfo;
import com.libre.framework.common.security.support.SecurityUtil;
import com.libre.framework.security.pojo.dto.AuthUser;
import com.libre.framework.system.pojo.entity.SysMenu;
import com.libre.framework.system.pojo.entity.SysRole;
import com.libre.framework.system.pojo.entity.SysUser;
import com.libre.framework.system.pojo.vo.MenuVO;
import com.libre.framework.system.service.SysMenuService;
import com.libre.framework.system.service.SysUserService;
import com.libre.framework.system.toolkit.MenuUtil;
import com.libre.toolkit.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Set;
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
		JwtUser jwtUser = new JwtUser();
		jwtUser.setId(authUser.getId());
		SysUser sysUser = sysUserService.findUserById(authUser.getId());
		jwtUser.setIsAdmin(authUser.getIsAdmin());
		List<SysRole> roleList = authUser.getRoleList();
		List<String> roles = roleList.stream().map(SysRole::getPermission).collect(Collectors.toList());
		jwtUser.setRoleList(roles);
		jwtUser.setUsername(authUser.getUsername());
		jwtUser.setAvatar(sysUser.getAvatar());
		jwtUser.setGender(sysUser.getGender());
		jwtUser.setPhone(sysUser.getPhone());
		jwtUser.setEmail(sysUser.getEmail());
		jwtUser.setNickName(sysUser.getNickName());
		return R.data(jwtUser);
	}

	@GetMapping("/menus")
	public R<List<MenuVO>> getMenus() { // 1. 超级管理员
		AuthUser user = SecurityUtil.getUser();
		if (SecurityConstant.IS_ADMIN_YES.equals(user.getIsAdmin())) {
			List<SysMenu> menuList = menuService.getAllMenu();
			return R.data(MenuUtil.transformList(menuList));
		}
		// 2. 其他用户
		List<SysRole> roleList = user.getRoleList();
		if (roleList == null || roleList.isEmpty()) {
			return R.data(Collections.emptyList());
		}
		Set<Long> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toSet());
		List<SysMenu> menuList = menuService.getNavByRoleIds(roleIds);
		return R.data(MenuUtil.transformList(menuList));
	}

}
