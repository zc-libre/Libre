package com.libre.admin.project.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色部门表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "角色部门表")
@Data
@TableName(value = "sys_role_dept")
public class RoleDept {
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long deptId;
}
