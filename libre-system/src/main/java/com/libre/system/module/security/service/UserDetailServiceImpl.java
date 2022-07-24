package com.libre.system.module.security.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.libre.system.module.security.pojo.RoleInfo;
import com.libre.system.module.security.service.dto.AuthUserDTO;
import com.libre.system.module.security.service.dto.AuthUser;
import com.libre.system.module.security.utils.SecurityUtil;

import com.libre.system.module.system.service.*;
import com.libre.system.module.system.service.convert.SysDeptConvert;
import com.libre.system.module.system.service.convert.SysPostConvert;
import com.libre.system.module.system.service.convert.SysRoleConvert;

import com.libre.toolkit.core.StringUtil;
import com.libre.system.module.system.entity.*;
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

import java.util.*;
import java.util.stream.Collectors;

import static com.libre.common.constant.LibreConstants.PASSWORD_PREFIX;

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

	private final SysDeptService deptService;

	private final SysPostService postService;

	private final SysRoleConvert roleConvert;

	private final SysDeptConvert deptConvert;

	private final SysPostConvert postConvert;

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
		Boolean isAdmin = sysUser.getIsAdmin();
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
		Boolean enabled = sysUser.getEnabled();
		boolean accountNonLocked = !sysUser.getLocked();
		Collection<? extends GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(dbAuthSet.toArray(new String[0]));
		Long deptId = sysUser.getDeptId();
		SysDept sysDept = null;
		if (Objects.nonNull(deptId)) {
			sysDept = deptService.getById(deptId);
		}

		List<SysPost> postList = postService.getListByUserId(userId);

		AuthUser jwtUser = new AuthUser(username, PASSWORD_PREFIX + password, enabled, accountNonLocked, authorities);
		jwtUser.setUserId(sysUser.getId());
		jwtUser.setNickName(sysUser.getNickName());
		jwtUser.setIsAdmin(sysUser.getIsAdmin());
		jwtUser.setGender(sysUser.getGender());
		jwtUser.setEmail(sysUser.getEmail());
		jwtUser.setPhone(sysUser.getPhone());
		jwtUser.setAvatar(sysUser.getAvatar());
		if (Objects.nonNull(sysDept)) {
			jwtUser.setDept(deptConvert.sourceToTarget(sysDept));
		}
		if (CollectionUtils.isNotEmpty(postList)) {
			jwtUser.setPostList(postConvert.sourceToTarget(postList));
		}
		if (CollectionUtils.isNotEmpty(roleInfoList)) {
			jwtUser.setRoleList(roleInfoList);
		}

		return jwtUser;
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
		sysUser.setLocked(Boolean.TRUE);
		return userService.updateByUsername(authUser.getUsername(), sysUser);
	}

	private void loadRoleAuthorities(List<SysRole> roleList, Set<String> dbAuthsSet) {
		roleList.stream().map(SysRole::getTitle).filter(StringUtil::isNotBlank)
				.forEach(x -> dbAuthsSet.add(SecurityUtil.SECURITY_ROLE_PREFIX + x));
	}

	private void loadUserAuthorities(List<SysRole> roleList, Set<String> dbAuthSet, Boolean isAdmin) {
		List<SysMenu> menuList;
		// 超级管理员有所有资源权限
		if (Boolean.TRUE.equals(isAdmin)) {
			menuList = sysMenuService.list();
		}
		else {
			Set<Long> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toSet());
			menuList = sysMenuService.getListByRoleIds(roleIds);
		}
		menuList.stream().map(SysMenu::getPermission).filter(StringUtil::isNotBlank).forEach(dbAuthSet::add);
	}

}
