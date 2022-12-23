package com.libre.framework.system.module.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.framework.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "部门表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_dept")
public class SysDept extends BaseEntity {

	/**
	 * 父id
	 */
	@ApiModelProperty(value = "父id")
	private Long parentId;

	/**
	 * 部门名称
	 */
	@ApiModelProperty(value = "部门名称")
	private String deptName;

}
