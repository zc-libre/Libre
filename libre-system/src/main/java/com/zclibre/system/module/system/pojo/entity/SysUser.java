package com.zclibre.system.module.system.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zclibre.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户表
 * @author zhao.cheng
 */
@ApiModel(value = "用户表")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
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
    @ApiModelProperty(value = "密码")
    private String password;


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
     * 用户类型（0系统用户 1管理员）
     */
    @ApiModelProperty(value = "用户类型（0系统用户 1管理员）")
    private Integer isAdmin;

    /**
     * 帐号状态（0停用 1正常）
     */
    @ApiModelProperty(value = "帐号状态（0停用 1正常）")
    private Integer enabled;

    /**
     * 登录状态（0:正常 1:锁定）
     */
    @ApiModelProperty(value = "登录状态")
    private Integer locked;
}
