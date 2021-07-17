package com.libre.admin.framework.security.service;

import com.libre.admin.framework.security.auth.AuthUser;

public interface UserLockService {

	/**
	 * 锁定用户
	 *
	 * @param authUser AuthUser
	 * @return {boolean}
	 */
	boolean updateLockUser(AuthUser authUser);

}
