package com.libre.common.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author zhao.cheng
 * @date 2021/1/30
 */
@Data
public class SecurityUser {

    private Long id;

    /**
     * 账户
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 角色id
     */
    private List<Long> roleIds;


    @ApiModelProperty(value = "角色集合")
    private List<String> roles;

    /**
     * 部门id
     */
    private Long deptId;


    private Long postId;

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

}
