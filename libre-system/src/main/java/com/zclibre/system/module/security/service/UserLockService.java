package com.zclibre.system.module.security.service;

import com.zclibre.system.module.security.pojo.dto.AuthUserDTO;

public interface UserLockService {

	/**
	 * 锁定用户
	 *
	 * @param authUser AuthUser
	 * @return {boolean}
	 */
	boolean updateLockUser(AuthUserDTO authUser);

}
