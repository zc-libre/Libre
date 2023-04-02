package com.libre.framework.security.pojo.dto;

import com.libre.framework.common.security.dto.RoleInfo;
import com.libre.framework.system.pojo.entity.SysRole;
import com.libre.security.pojo.OAuth2User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @author: Libre
 * @Date: 2023/3/18 12:59 AM
 */
@EqualsAndHashCode(callSuper = true)
public class AuthUser extends OAuth2User {

    @Getter
    @Setter
    private List<SysRole> roleList;

    @Getter
    @Setter
    private Integer isAdmin;

    public AuthUser(Long id, String username, String password, String phone, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(id, username, password, phone, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
