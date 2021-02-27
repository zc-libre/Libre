package com.libre.module.security.vo;

import lombok.Data;

/**
 * @author zhao.cheng
 * @Date 2021/2/27
 */
@Data
public class UserVO {

    private Long id;
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
