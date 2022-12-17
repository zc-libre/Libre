package com.libre.framework.common.security;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Getter
@Setter
public class AuthUser extends User {

	private Long userId;

	private String nickName;

	private Integer gender;

	private Integer isAdmin;

	private String avatar;

	private String email;

	private String phone;


	private List<RoleInfo> roleList;


	public AuthUser(String username, String password, boolean enabled, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, true, true, accountNonLocked, authorities);
	}

	public static AuthUser formUser(AuthUser user, String newPassword) {
		AuthUser authUser = new AuthUser(user.getUsername(), newPassword, user.isEnabled(), user.isAccountNonLocked(),
				user.getAuthorities());
		authUser.setUserId(user.getUserId());
		authUser.setNickName(user.getNickName());
		authUser.setIsAdmin(user.getIsAdmin());
		authUser.setGender(user.getGender());
		authUser.setAvatar(user.getAvatar());
		authUser.setEmail(user.getEmail());
		authUser.setPhone(user.getPhone());
		authUser.setRoleList(user.getRoleList());
		return authUser;
	}

}
