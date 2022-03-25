package com.libre.admin.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "角色表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
public class SysRole extends BaseEntity {

    /**
     * 角色名
     */
    @ApiModelProperty(value = "角色名")
    private String roleName;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;

    /**
     * 角色状态（0正常 1停用）
     */
    @ApiModelProperty(value = "角色状态（0正常 1停用）")
    private Integer status;

    /**
     * 角色权限字符串
     */
    private String title;

}
