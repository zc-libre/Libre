package com.libre.framework.tookit.moudle.quartz.groovy;

import com.libre.toolkit.core.StringUtil;
import groovy.lang.GroovyClassLoader;

import java.util.concurrent.ConcurrentHashMap;


public class GroovyScriptFactory {

	/**
	 * 单例
	 */
	private static final GroovyScriptFactory GROOVY_SCRIPT_FACTORY = new GroovyScriptFactory();

	/**
	 * groovy类加载器
	 */
	private final GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

	/**
	 * 缓存Class
	 */
	private final ConcurrentHashMap<String, Class<?>> classCache = new ConcurrentHashMap<>();

	/**
	 * 获取单例
	 * @return 实例
	 */
	public static GroovyScriptFactory getInstance() {
		return GROOVY_SCRIPT_FACTORY;
	}

	/**
	 * 加载创建实例，prototype
	 * @param codeSource 源代码
	 * @return 实例
	 * @throws Exception 异常
	 */
	public Script loadNewInstance(String codeSource) throws Exception {
		if (StringUtil.isNotBlank(codeSource)) {
			Class<?> clazz = getCodeSourceClass(codeSource);
			if (clazz != null) {
				Object instance = clazz.getDeclaredConstructor().newInstance();
				if (instance instanceof Script) {;
					return (Script) instance;
				}
				else {
					throw new IllegalArgumentException(
							StringUtil.format("创建实例失败，[{}]不是IScript的子类", instance.getClass()));
				}
			}
		}
		throw new IllegalArgumentException("创建实例失败，instance is null");
	}

	/**
	 * code text -> class 通过类加载器生成class
	 * @param codeSource 源代码
	 * @return class
	 */
	private Class<?> getCodeSourceClass(String codeSource) {
		Class<?> aClass = classCache.get(codeSource);
		if (aClass == null) {
			aClass = groovyClassLoader.parseClass(codeSource);
			classCache.putIfAbsent(codeSource, aClass);
		}
		return aClass;
	}

}