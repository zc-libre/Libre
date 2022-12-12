package com.libre.framework.system.module.system.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libre.framework.system.module.security.pojo.DeptInfo;
import com.libre.framework.system.module.security.pojo.RoleInfo;
import com.libre.framework.system.module.security.pojo.PostInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 */
@Getter
@Setter
public class UserDTO implements Serializable {

    private Long id;

    private Set<RoleInfo> roles;

    private Set<PostInfo> jobs;

    private DeptInfo dept;

    private Long deptId;

    private String username;

    private String nickName;

    private String email;

    private String phone;

    private String gender;

    private String avatarName;

    private String avatarPath;

    @JsonIgnore
    private String password;

    private Boolean enabled;

    @JsonIgnore
    private Boolean isAdmin = false;

    private LocalDateTime pwdResetTime;
}