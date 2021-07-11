package com.libre.admin.project.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libre.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表
 * @author zhao.cheng
 */
@ApiModel(value = "用户表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {

    /**
     * 账户
     */
    @ApiModelProperty(value = "账户")
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    @ApiModelProperty(value = "密码")
    private String password;

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

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 邮件
     */
    @ApiModelProperty(value = "邮件")
    private String email;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;


}
