package com.libre.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.common.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;



/**
 * 用户表
 * @author zhaocheng
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮件
     */
    private String email;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 状态
     */
    private Integer status;

}
