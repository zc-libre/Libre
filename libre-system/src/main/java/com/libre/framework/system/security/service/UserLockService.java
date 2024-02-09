package com.libre.framework.system.security.service;

import com.libre.framework.common.security.dto.AuthUser;

public interface UserLockService {

	/**
	 * 锁定用户
	 * @param authUser AuthUser
	 * @return {boolean}
	 */
	boolean updateLockUser(AuthUser authUser);

}
