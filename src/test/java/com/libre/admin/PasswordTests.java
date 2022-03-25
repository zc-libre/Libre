package com.libre.admin;

import com.libre.admin.common.config.LibreSecurityProperties;
import com.libre.core.toolkit.RsaUtil;
import com.libre.core.tuple.KeyPair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ZC
 * @date 2021/11/7 15:06
 */
@SpringBootTest
public class PasswordTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LibreSecurityProperties properties;

    @Test
    void password() {
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    void rsa() {
        KeyPair keyPair1 = properties.getLoginKeyPair();
        String publicBase64 = keyPair1.getPublicBase64();
        KeyPair keyPair2 = properties.getLoginKeyPair();
        String privateBase64 = keyPair2.getPrivateBase64();
        String s = RsaUtil.encryptToBase64(publicBase64, "123456");
        String s1 = RsaUtil.decryptFromBase64(privateBase64, s);
        System.out.println(s1);
    }
}
