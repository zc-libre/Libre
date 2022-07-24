package com.libre.system.module.system.vo;

import com.libre.system.module.security.jwt.JwtUser;
import lombok.Data;

/**
 * @author Libre
 * @date 2021/7/12 18:00
 */
@Data
public class JwtUserVO {

    private JwtUser userInfo;

    private String publicKey;

    private String token;
}
