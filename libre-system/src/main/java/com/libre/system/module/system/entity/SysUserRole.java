package com.libre.system.module.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 用户角色表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "用户角色表")
@Data
@TableName(value = "sys_user_role")
public class SysUserRole {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;
}
