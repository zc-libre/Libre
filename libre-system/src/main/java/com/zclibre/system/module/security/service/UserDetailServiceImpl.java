package com.zclibre.system.module.security.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.zclibre.system.module.security.constant.SecurityConstant;
import com.zclibre.system.module.security.service.dto.AuthUser;
import com.zclibre.system.module.security.pojo.RoleInfo;
import com.zclibre.system.module.security.service.dto.AuthUserDTO;
import com.zclibre.system.module.security.utils.SecurityUtil;

import com.zclibre.system.module.system.constant.UserConstants;
import com.zclibre.system.module.system.service.SysMenuService;
import com.zclibre.system.module.system.service.SysRoleService;
import com.zclibre.system.module.system.service.SysUserService;
import com.zclibre.system.module.system.service.convert.SysRoleConvert;

import com.libre.toolkit.core.StringUtil;
import com.zclibre.system.module.system.entity.SysMenu;
import com.zclibre.system.module.system.entity.SysRole;
import com.zclibre.system.module.system.entity.SysUser;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;



/**
 * @author Libre
 * @date 2021/7/12 14:09
 */
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService, UserDetailsPasswordService, UserLockService {

	private final SysUserService userService;

	private final SysRoleService sysRoleService;

	private final SysMenuService sysMenuService;

	private final SysRoleConvert roleConvert;

	@Override
	public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtil.isBlank(username)) {
			throw new UsernameNotFoundException("userName is blank!");
		}
		SysUser sysUser = userService.getByUsername(username);
		if (Objects.isNull(sysUser)) {
			throw new UsernameNotFoundException("User is not found!");
		}
		Long userId = sysUser.getId();
		Integer isAdmin = sysUser.getIsAdmin();
		List<SysRole> roleList = sysRoleService.getListByUserId(userId);
		Set<String> dbAuthSet = Sets.newHashSet();
		List<RoleInfo> roleInfoList = Lists.newArrayList();
		if (CollectionUtils.isNotEmpty(roleList)) {
			roleInfoList.addAll(roleConvert.sourceToTarget(roleList));
			// 获取角色
			loadRoleAuthorities(roleList, dbAuthSet);
			// 获取资源，超级管理员有所有资源
			loadUserAuthorities(roleList, dbAuthSet, isAdmin);
		}
		String password = sysUser.getPassword();
		boolean enabled = ObjectUtils.nullSafeEquals(sysUser.getEnabled(), UserConstants.USER_ENABLE);
		boolean accountNonLocked = ObjectUtils.nullSafeEquals(sysUser.getLocked(), UserConstants.USER_UNLOCK);

		Collection<? extends GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(dbAuthSet.toArray(new String[0]));

		AuthUser authuser = new AuthUser(username, SecurityConstant.PASSWORD_PREFIX + password, enabled, accountNonLocked, authorities);
		authuser.setUserId(sysUser.getId());
		authuser.setNickName(sysUser.getNickName());
		authuser.setIsAdmin(sysUser.getIsAdmin());
		authuser.setGender(sysUser.getGender());
		authuser.setEmail(sysUser.getEmail());
		authuser.setPhone(sysUser.getPhone());
		authuser.setAvatar(sysUser.getAvatar());

		if (CollectionUtils.isNotEmpty(roleInfoList)) {
			authuser.setRoleList(roleInfoList);
		}

		return authuser;
	}

	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		AuthUser authUser = (AuthUser) user;
		SysUser sysUser = new SysUser();
		sysUser.setId(authUser.getUserId());
		sysUser.setPassword(newPassword);
		userService.updateById(sysUser);
		return AuthUser.formUser(authUser, newPassword);
	}

	@Override
	public boolean updateLockUser(AuthUserDTO authUser) {
		Assert.notNull(authUser.getUsername(), "username must not be null");
		SysUser sysUser = new SysUser();
		sysUser.setLocked(UserConstants.USER_LOCK);
		return userService.updateByUsername(authUser.getUsername(), sysUser);
	}

	private void loadRoleAuthorities(List<SysRole> roleList, Set<String> dbAuthsSet) {
		roleList.stream().map(SysRole::getTitle).filter(StringUtil::isNotBlank)
				.forEach(x -> dbAuthsSet.add(SecurityUtil.SECURITY_ROLE_PREFIX + x));
	}

	private void loadUserAuthorities(List<SysRole> roleList, Set<String> dbAuthSet, Integer isAdmin) {
		List<SysMenu> menuList;
		// 超级管理员有所有资源权限
		if (ObjectUtils.nullSafeEquals(isAdmin, UserConstants.IS_ADMIN_YES)) {
			menuList = sysMenuService.list();
		}
		else {
			Set<Long> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toSet());
			menuList = sysMenuService.getListByRoleIds(roleIds);
		}
		menuList.stream().map(SysMenu::getPermission).filter(StringUtil::isNotBlank).forEach(dbAuthSet::add);
	}

}