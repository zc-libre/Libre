package com.libre.admin.module.security.service;

import com.libre.admin.module.security.auth.AuthUser;

public interface UserLockService {

	/**
	 * 锁定用户
	 *
	 * @param authUser AuthUser
	 * @return {boolean}
	 */
	boolean updateLockUser(AuthUser authUser);

}
