package com.libre.framework.security.service;

import com.libre.framework.common.security.AuthUser;

public interface UserLockService {

	/**
	 * 锁定用户
	 * @param authUser AuthUser
	 * @return {boolean}
	 */
	boolean updateLockUser(AuthUser authUser);

}
