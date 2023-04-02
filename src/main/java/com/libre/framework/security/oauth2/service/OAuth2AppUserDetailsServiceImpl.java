package com.libre.framework.security.oauth2.service;

import com.google.common.collect.Sets;
import com.libre.framework.common.constant.CacheConstants;
import com.libre.framework.common.security.constant.SecurityConstant;
import com.libre.framework.common.security.support.SecurityUtil;
import com.libre.framework.security.pojo.dto.UserInfo;
import com.libre.framework.system.constant.UserConstants;
import com.libre.framework.system.pojo.entity.SysMenu;
import com.libre.framework.system.pojo.entity.SysRole;
import com.libre.framework.system.pojo.entity.SysUser;
import com.libre.framework.system.service.SysMenuService;
import com.libre.framework.system.service.SysUserService;
import com.libre.security.constant.SecurityConstants;
import com.libre.security.pojo.OAuth2User;
import com.libre.security.service.OAuth2UserDetailsService;
import com.libre.toolkit.core.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户详细信息
 *
 * @author lengleng hccake
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AppUserDetailsServiceImpl implements OAuth2UserDetailsService {

	private final SysUserService sysUserService;

	private final CacheManager cacheManager;

	private final SysMenuService sysMenuService;

	/**
	 * 手机号登录
	 * @param phone 手机号
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String phone) {
		Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
		if (cache != null && cache.get(phone) != null) {
			return (OAuth2User) cache.get(phone).get();
		}

		UserInfo userInfo = sysUserService.findUserByPhone(phone);
		SysUser user = userInfo.getSysUser();
		List<SysRole> roleList = userInfo.getRoleList();
		Set<String> dbAuthSet = Sets.newHashSet();
		if (CollectionUtils.isNotEmpty(roleList)) {
			// 获取角色
			loadRoleAuthorities(roleList, dbAuthSet);
			// 获取资源，超级管理员有所有资源
			loadUserAuthorities(roleList, dbAuthSet, user.getIsAdmin());
		}

		boolean enabled = ObjectUtils.nullSafeEquals(user.getEnabled(), UserConstants.USER_ENABLE);
		boolean accountNonLocked = ObjectUtils.nullSafeEquals(user.getLocked(), UserConstants.USER_UNLOCK);

		Collection<? extends GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(dbAuthSet.toArray(new String[0]));

		OAuth2User userDetails = new OAuth2User(user.getId(), user.getUsername(),
				SecurityConstants.BCRYPT + user.getPassword(), user.getPhone(), enabled, true, true, accountNonLocked,
				authorities);

		if (cache != null) {
			cache.put(phone, userDetails);
		}
		return userDetails;
	}

	/**
	 * check-token 使用
	 * @param pigUser user
	 * @return
	 */
	@Override
	public UserDetails loadUserByUser(OAuth2User pigUser) {
		return this.loadUserByUsername(pigUser.getPhone());
	}

	/**
	 * 是否支持此客户端校验
	 * @param clientId 目标客户端
	 * @return true/false
	 */
	@Override
	public boolean support(String clientId, String grantType) {
		return SecurityConstants.APP.equals(grantType);
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
