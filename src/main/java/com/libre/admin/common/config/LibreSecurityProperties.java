package com.libre.admin.common.config;

import com.google.common.collect.Lists;
import com.libre.core.toolkit.RsaUtil;
import com.libre.core.tuple.KeyPair;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.util.List;

/**
 * @author ZC
 * @date 2021/7/12 10:42
 */
@Data
@Validated
@ConfigurationProperties("libre.security")
public class LibreSecurityProperties {

    /**
     * 忽略的地址
     */
    private final List<String> permitAll = Lists.newArrayList();
    /**
     * 登录配置
     */
    private final Login login = new Login();
    /**
     * token配置
     */
    private final JwtToken jwtToken = new JwtToken();
    /**
     * 登录密码加解密 rsa 秘钥
     */
    @NestedConfigurationProperty
    private KeyPair loginKeyPair = RsaUtil.genKeyPair();
    /**
     * 用户密码加解密 rsa 秘钥
     */
    @NestedConfigurationProperty
    private KeyPair userKeyPair = RsaUtil.genKeyPair();

    /**
     * 登录配置
     */
    @Getter
    @Setter
    public static class Login {
        /**
         * 登录重试锁定次数，默认：5
         */
        private int retryLimit = 5;
        /**
         * 登录重试锁定cache名，默认：retryLimitCache
         */
        private String retryLimitCacheName = "retryLimitCache#30m";
    }

    /**
     * 登录配置
     */
    @Getter
    @Setter
    public static class JwtToken {
        /**
         * 令牌自定义标识
         */
        private String header = "Authorization";
        /**
         * 令牌秘钥
         */
        @NotBlank
        private String secret;
        /**
         * 秘钥的签名算法
         */
        private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        /**
         * jwt token 接受者
         */
        private String audience = "Libre";
        /**
         * jwt token 签发者
         */
        private String issuer = "Libre";
        /**
         * 令牌有效期（默认8小时)。
         */
        private Duration expireTime = Duration.ofHours(8);
        /**
         * 记住密码有效期（默认30天）
         */
        private Duration rememberMeTime = Duration.ofDays(30);

        /**
         * token 续期检查(单位：小时)
         */
        private Duration detectTime = Duration.ofHours(4);

        /**
         * 续期时间
         */
        private Duration renewTime = Duration.ofHours(4);
        /**
         * redis token 存储前缀
         */
        private String storePrefix = "Libre-Admin:token:";
    }

}
