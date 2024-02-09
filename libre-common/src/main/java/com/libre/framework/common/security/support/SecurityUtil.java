package com.libre.framework.common.security.support;

import com.libre.boot.toolkit.RequestUtils;
import com.libre.framework.common.security.constant.SecurityConstant;
import com.libre.framework.common.security.dto.AuthUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * @author Libre
 * @date 2021/7/12 14:53
 */
public class SecurityUtil {

	/**
	 * 角色前缀
	 */
	public static final String SECURITY_ROLE_PREFIX = "ROLE_";

	/**
	 * 获取Authentication
	 */
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 */
	public static AuthUser getUser(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof AuthUser) {
			return ((AuthUser) principal);
		}

		return null;
	}

	public static OAuth2User getOauth2User(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof OAuth2User) {
			return (OAuth2User) principal;
		}
		return null;
	}


	/**
	 * 获取用户
	 */
	public static AuthUser getUser() {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return null;
		}
		return getUser(authentication);
	}

	/**
	 * 获取用户名
	 */
	public static String getUserName() {
		AuthUser authUser = getUser();
		return authUser == null ? null : authUser.getUsername();
	}

	/**
	 * 退出
	 */
	public static void logout() {
		HttpServletRequest request = RequestUtils.getRequest();
		new SecurityContextLogoutHandler().logout(request, null, null);
	}

	public static boolean isAdmin(Integer isAdmin) {
		return SecurityConstant.IS_ADMIN_YES.equals(isAdmin);
	}

}
