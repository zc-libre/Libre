package com.libre.framework.toolkit.moudle.social.core.websocket.server.account;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 默认的账号存储
 *
 * @author L.cm
 */
public class DefaultWsAccountStore implements IWsAccountStore {

	/**
	 * 可能会堆满内存，尽量不要使用这种方式
	 */
	private Set<String> data = new LinkedHashSet<>();

	@Override
	public List<String> listAll() {
		return new ArrayList<>(data);
	}

	@Override
	public boolean has(String accountId) {
		return data.contains(accountId);
	}

	@Override
	public void put(String accountId) {
		data.add(accountId);
	}

	@Override
	public void remove(String accountId) {
		data.remove(accountId);
	}

}
