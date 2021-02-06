package com.libre.module.oauth.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
public class JwtUserDTO implements UserDetails {


    private final UserDTO user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return user.getUsername();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public JwtUserDTO(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
