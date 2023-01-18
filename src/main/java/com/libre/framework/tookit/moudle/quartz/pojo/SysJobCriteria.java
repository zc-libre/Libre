package com.libre.framework.tookit.moudle.quartz.pojo;

import com.libre.framework.common.base.BaseCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author: Libre
 * @Date: 2022/12/30 9:06 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SysJobCriteria extends BaseCriteria {

	/**
	 * 定时任务状态
	 */
	private String jobStatus;

}
