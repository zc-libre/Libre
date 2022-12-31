package com.libre.framework.tookit.moudle.quartz.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.framework.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Libre
 * @Date: 2022/12/30 8:44 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_job")
public class SysJob extends BaseEntity {

	public static final String JOB_KEY = "JOB_KEY";

	/**
	 * 定时任务名称
	 */
	private String jobName;

	/**
	 * 定时任务beanName
	 */
	private String beanName;

	/**
	 * 方法名
	 */
	private String methodName;

	/**
	 * 参数
	 */
	private String params;


	/**
	 * cron 表达式
	 */
	private String cronExpression;


}
