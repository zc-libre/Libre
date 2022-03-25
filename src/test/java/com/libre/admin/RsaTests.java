package com.libre.admin;

import com.libre.core.toolkit.RsaUtil;
import com.libre.core.tuple.KeyPair;

/**
 * @author ZC
 * @date 2021/11/7 15:49
 */
public class RsaTests {
    public static void main(String[] args) {
        KeyPair keyPair = RsaUtil.genKeyPair();
        String publicBase64 = keyPair.getPublicBase64();
        String privateBase64 = keyPair.getPrivateBase64();
        String s = RsaUtil.encryptToBase64(publicBase64, "123456");
        String s1 = RsaUtil.decryptFromBase64(privateBase64, s);
        System.out.println(s1);
    }
}
