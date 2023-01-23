package com.libre.framework.log.annotation;

import com.libre.framework.log.support.SysLogType;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

	/**
	 * 描述
	 * @return {String}
	 */
	String value();

	SysLogType type() default SysLogType.Api;

}
