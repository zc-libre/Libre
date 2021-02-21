package com.libre.module.security.service.dto;

import com.libre.common.tookit.JsonUtil;

import java.util.Date;

/**
 * 在线用户
 * @author zhao.cheng
 */

public class OnlineUserDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * token
     */
    private String key;

    /**
     * 登录时间
     */
    private Date loginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }

    public OnlineUserDTO(String username, String key, Date loginTime) {
        this.username = username;
        this.key = key;
        this.loginTime = loginTime;
    }

    public OnlineUserDTO() {

    }
}
