package com.zclibre.system.module.security.pojo.dto;

import com.zclibre.system.module.system.pojo.entity.SysRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Libre
 * @Date: 2022/8/27 12:21 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

	private String username;

	private String token;

	private String avatar;

	private List<SysRole> roles;

	private List<String> permissions;

	private Integer isAdmin;

	public UserInfo(String username, String token) {
		this.username = username;
		this.token = token;
	}

}
