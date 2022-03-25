package com.libre.admin.module.security.jwt;

import com.google.common.collect.Lists;
import com.libre.admin.module.security.pojo.DeptInfo;
import com.libre.admin.module.security.pojo.PostInfo;
import com.libre.admin.module.security.pojo.RoleInfo;
import lombok.Data;

import java.util.List;

/**
 * @author ZC
 * @date 2021/7/12 10:28
 */
@Data
public class JwtUser {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 登录名
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户性别（0男 1女 2未知）
     */
    private Integer gender;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 是否admin
     */
    private Boolean isAdmin;
    /**
     * 部门信息
     */
    private DeptInfo dept;
    /**
     * 岗位信息
     */
    private List<PostInfo> posts;
    /**
     * 角色信息
     */
    private List<RoleInfo> roles = Lists.newArrayList();
    /**
     * 角色信息
     */
    private List<String> roleList;
}
