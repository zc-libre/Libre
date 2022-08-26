package com.zclibre.system.module.security.controller.service;

import com.zclibre.system.module.security.controller.service.dto.AuthUserDTO;

public interface UserLockService {

	/**
	 * 锁定用户
	 *
	 * @param authUser AuthUser
	 * @return {boolean}
	 */
	boolean updateLockUser(AuthUserDTO authUser);

}
