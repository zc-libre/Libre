package com.libre.framework.social.core.websocket.server.account;

import java.util.List;

/**
 * account 存储
 *
 * @author L.cm
 */
public interface IWsAccountStore {
	/**
	 * redis 缓存 key
	 */
	String REDIS_KEY = "libre:ws:accounts";

	/**
	 * 获取所有账号
	 *
	 * @return 账号列表
	 */
	List<String> listAll();

	/**
	 * 判断账号是否存在
	 *
	 * @param accountId 账号
	 * @return 是否存在
	 */
	boolean has(String accountId);

	/**
	 * 存储账号
	 *
	 * @param accountId 账号id
	 */
	void put(String accountId);

	/**
	 * 删除账号
	 *
	 * @param accountId
	 */
	void remove(String accountId);

}
