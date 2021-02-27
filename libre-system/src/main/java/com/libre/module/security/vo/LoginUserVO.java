package com.libre.module.security.vo;

import com.libre.common.security.model.JwtUser;
import lombok.Data;

/**
 * @author zhao.cheng
 * @Date 2021/2/21
 */
@Data
public class LoginUserVO {

    private String token;

    private JwtUser user;
}
