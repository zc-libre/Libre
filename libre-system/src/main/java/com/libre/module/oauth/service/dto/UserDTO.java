package com.libre.module.oauth.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libre.common.tookit.JsonUtil;

/**
 * @author zhao.cheng
 * @date 2021/1/30
 */

public class UserDTO {

    private String id;

    private String username;

    @JsonIgnore
    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
       return JsonUtil.toPrettyJson(this);
    }
}
