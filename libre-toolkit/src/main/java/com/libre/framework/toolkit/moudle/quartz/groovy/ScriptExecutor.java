package com.libre.framework.toolkit.moudle.quartz.groovy;

import java.util.concurrent.ConcurrentHashMap;

public class ScriptExecutor {

	/**
	 * 缓存实例
	 */
	private final ConcurrentHashMap<String, Script> objCache = new ConcurrentHashMap<>();

	/**
	 * 执行脚本
	 * @param id 实例Id
	 * @return 运行结果
	 */
	public void run(String id, String param) {
		Script script = objCache.get(id);
		if (script == null) {
			throw new IllegalArgumentException("未找到实例, id = [" + id + "]");
		}
		else {
			script.run(param);
		}
	}

	/**
	 * 注册实例
	 * @param id 实例id
	 * @param script 实例
	 * @return 返回前一个实例，如果为null，则是新插入
	 */
	public Script register(String id, Script script) {
		return objCache.put(id, script);
	}

	/**
	 * 移除实例
	 * @param id 实例id
	 * @return 移除的实例
	 */
	public Script remove(String id) {
		return objCache.remove(id);
	}

}