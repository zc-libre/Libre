package com.libre.admin.module.security.auth;

import cn.hutool.core.collection.CollUtil;
import com.libre.admin.module.security.jwt.JwtUser;
import com.libre.admin.module.security.pojo.DeptInfo;
import com.libre.admin.module.security.pojo.PostInfo;
import com.libre.admin.module.security.pojo.RoleInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZC
 * @date 2021/7/12 10:21
 */
@Getter
@Setter
public class AuthUser extends User {

    private Long userId;

    private String nickName;

    private Integer gender;

    private Boolean isAdmin;

    private String avatar;

    private String email;

    private String phone;

    private DeptInfo dept;

    private List<PostInfo> postList;

    private List<RoleInfo> roleList;


    public AuthUser(String username,
                    String password,
                    boolean enabled,
                    boolean accountNonLocked,
                    Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, true, true, accountNonLocked, authorities);
    }

    public JwtUser toJwtUser() {
        JwtUser jwtUser = new JwtUser();
        jwtUser.setId(this.getUserId());
        jwtUser.setUserName(this.getUsername());
        jwtUser.setNickName(this.getNickName());
        jwtUser.setGender(this.getGender());
        jwtUser.setAvatar(this.getAvatar());
        jwtUser.setEmail(this.getEmail());
        jwtUser.setPhone(this.getPhone());
        jwtUser.setIsAdmin(this.getIsAdmin());
        jwtUser.setDept(this.getDept());
        jwtUser.setPosts(this.getPostList());
        jwtUser.setRoles(this.getRoleList());
        if (CollUtil.isNotEmpty(this.getRoleList())) {
            jwtUser.setRoleList(this.getRoleList().stream().map(RoleInfo::getTitle).collect(Collectors.toList()));
        }
        return jwtUser;
    }

    public static AuthUser formLibreUser(AuthUser user, String newPassword) {
        AuthUser authUser = new AuthUser(
                user.getUsername(),
                newPassword,
                user.isEnabled(),
                user.isAccountNonLocked(),
                user.getAuthorities()
        );
        authUser.setUserId(user.getUserId());
        authUser.setNickName(user.getNickName());
        authUser.setIsAdmin(user.getIsAdmin());
        authUser.setGender(user.getGender());
        authUser.setAvatar(user.getAvatar());
        authUser.setEmail(user.getEmail());
        authUser.setPhone(user.getPhone());
        authUser.setDept(user.getDept());
        authUser.setPostList(user.getPostList());
        authUser.setRoleList(user.getRoleList());
        return authUser;
    }
}
