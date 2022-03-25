package com.libre.admin.module.system.vo;

import com.libre.admin.module.security.jwt.JwtUser;
import lombok.Data;

/**
 * @author ZC
 * @date 2021/7/12 18:00
 */
@Data
public class JwtUserVO {

    private JwtUser userInfo;

    private String publicKey;

    private String token;
}
