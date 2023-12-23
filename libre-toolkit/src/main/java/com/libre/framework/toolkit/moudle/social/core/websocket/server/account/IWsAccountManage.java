package com.libre.framework.toolkit.moudle.social.core.websocket.server.account;

import java.util.List;

/**
 * 账号管理接口
 *
 * @author L.cm
 */
public interface IWsAccountManage {

	/**
	 * 获取所有的账号列表
	 * @return 账号列表
	 */
	List<String> getAccountList();

	/**
	 * 账号是否在线
	 * @param accountId 账号id
	 * @return 是否在线
	 */
	boolean isOnline(String accountId);

}
