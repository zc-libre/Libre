package com.libre.framework.security.service;

import com.libre.framework.security.pojo.dto.AuthUser;


public interface UserLockService {

	/**
	 * 锁定用户
	 * @param authUser AuthUser
	 * @return {boolean}
	 */
	boolean updateLockUser(AuthUser authUser);

}
