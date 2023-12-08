package com.libre.framework.toolkit.moudle.social.core.websocket.server.account;

import org.redisson.Redisson;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import java.util.ArrayList;
import java.util.List;

/**
 * redisson 实现
 *
 * @author L.cm
 */
@AutoConfiguration
@ConditionalOnClass(Redisson.class)
public class RedissonWsAccountStore implements IWsAccountStore {
	private final RSet<String> rSet;

	@Autowired
	public RedissonWsAccountStore(RedissonClient redisson) {
		this.rSet = redisson.getSet(REDIS_KEY);
	}

	@Override
	public List<String> listAll() {
		return new ArrayList<>(rSet.readAll());
	}

	@Override
	public boolean has(String accountId) {
		return rSet.contains(accountId);
	}

	@Override
	public void put(String accountId) {
		rSet.add(accountId);
	}

	@Override
	public void remove(String accountId) {
		rSet.remove(accountId);
	}
}
