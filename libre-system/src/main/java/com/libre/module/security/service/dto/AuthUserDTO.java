
package com.libre.module.security.service.dto;

import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author zhao.cheng
 */
@ToString
public class AuthUserDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
