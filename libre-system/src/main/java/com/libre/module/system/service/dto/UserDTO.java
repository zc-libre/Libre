package com.libre.module.system.service.dto;

import com.libre.common.tookit.JsonUtil;
import lombok.Data;

/**
 * @author zhao.cheng
 * @date 2021/1/30
 */
@Data
public class UserDTO {

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

    @Override
    public String toString() {
       return JsonUtil.toPrettyJson(this);
    }
}
