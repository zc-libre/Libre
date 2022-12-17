/*
 * Copyright (c) 2019-2029, Dreamlu 卢春梦 (596392912@qq.com & www.dreamlu.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.libre.framework.logging.support;

import lombok.Getter;
import lombok.Setter;

/**
 * SysLog 数据承载
 *
 * @author L.cm
 */
@Getter
@Setter
public class SysLogEvent {

	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 登陆名
	 */
	private String userName;
	/**
	 * 日志类别
	 */
	private String logType;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 请求参数
	 */
	private String params;
	/**
	 * post data
	 */
	private String data;
	/**
	 * 是否成功[0失败,1成功]
	 */
	private Integer success;
	/**
	 * 类-方法
	 */
	private String classMethod;
	/**
	 * 异常信息
	 */
	private String exceptionDetail;
	/**
	 * 请求ip
	 */
	private String requestIp;
	/**
	 * 请求耗时
	 */
	private Long requestTime;
	/**
	 * ua 信息
	 */
	private String userAgent;
}
