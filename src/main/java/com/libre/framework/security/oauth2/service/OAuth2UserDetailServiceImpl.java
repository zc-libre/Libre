package com.libre.framework.security.oauth2.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.libre.framework.common.constant.CacheConstants;
import com.libre.framework.common.security.constant.SecurityConstant;
import com.libre.framework.common.security.dto.RoleInfo;
import com.libre.framework.common.security.support.SecurityUtil;
import com.libre.framework.security.pojo.dto.AuthUser;
import com.libre.framework.system.constant.UserConstants;
import com.libre.framework.system.pojo.entity.SysMenu;
import com.libre.framework.system.pojo.entity.SysRole;
import com.libre.framework.system.pojo.entity.SysUser;
import com.libre.framework.system.service.SysMenuService;
import com.libre.framework.system.service.SysRoleService;
import com.libre.framework.system.service.SysUserService;
import com.libre.framework.system.service.mapstruct.SysRoleMapping;
import com.libre.security.constant.SecurityConstants;
import com.libre.security.pojo.OAuth2User;
import com.libre.security.service.OAuth2UserDetailsService;
import com.libre.toolkit.core.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Libre
 * @Date: 2023/1/28 9:51 PM
 */
@Primary
@Component
@RequiredArgsConstructor
public class OAuth2UserDetailServiceImpl implements OAuth2UserDetailsService {

	private final SysUserService userService;

	private final CacheManager cacheManager;

	private final SysMenuService sysMenuService;

	private final SysRoleService sysRoleService;

	/**
	 * 用户名密码登录
	 * @param username 用户名
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		if (StringUtil.isBlank(username)) {
			throw new UsernameNotFoundException("userName is blank!");
		}

		Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
		if (cache != null && cache.get(username) != null) {
			return (AuthUser) Objects.requireNonNull(cache.get(username)).get();
		}

		SysUser user = userService.getByUsername(username);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException("User is not found!");
		}
		Long userId = user.getId();
		Integer isAdmin = user.getIsAdmin();

		List<SysRole> roleList = sysRoleService.getListByUserId(userId);
		Set<String> dbAuthSet = Sets.newHashSet();
		// List<RoleInfo> roleInfoList = Lists.newArrayList();
		// SysRoleMapping roleMapping = SysRoleMapping.INSTANCE;
		if (CollectionUtils.isNotEmpty(roleList)) {
			// roleInfoList.addAll(roleMapping.sourceToTarget(roleList));
			// 获取角色
			loadRoleAuthorities(roleList, dbAuthSet);
			// 获取资源，超级管理员有所有资源
			loadUserAuthorities(roleList, dbAuthSet, isAdmin);
		}

		boolean enabled = ObjectUtils.nullSafeEquals(user.getEnabled(), UserConstants.USER_ENABLE);
		boolean accountNonLocked = ObjectUtils.nullSafeEquals(user.getLocked(), UserConstants.USER_UNLOCK);

		Collection<? extends GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(dbAuthSet.toArray(new String[0]));

		AuthUser userDetails = new AuthUser(user.getId(), user.getUsername(),
				SecurityConstants.BCRYPT + user.getPassword(), user.getPhone(), enabled, true, true, accountNonLocked,
				authorities);
		userDetails.setRoleList(roleList);
		userDetails.setIsAdmin(userDetails.getIsAdmin());

		if (cache != null) {
			cache.put(username, userDetails);
		}

		return userDetails;
	}

	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}

	private void loadRoleAuthorities(List<SysRole> roleList, Set<String> dbAuthsSet) {
		roleList.stream().map(SysRole::getPermission).filter(StringUtil::isNotBlank)
				.forEach(x -> dbAuthsSet.add(SecurityUtil.SECURITY_ROLE_PREFIX + x));
	}

	private void loadUserAuthorities(List<SysRole> roleList, Set<String> dbAuthSet, Integer isAdmin) {
		List<SysMenu> menuList;
		// 超级管理员有所有资源权限
		if (ObjectUtils.nullSafeEquals(isAdmin, SecurityConstant.IS_ADMIN_YES)) {
			menuList = sysMenuService.list();
		}
		else {
			Set<Long> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toSet());
			menuList = sysMenuService.getListByRoleIds(roleIds);
		}
		menuList.stream().map(SysMenu::getPermission).filter(StringUtil::isNotBlank).forEach(dbAuthSet::add);
	}

}
