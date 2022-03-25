package com.libre.admin.module.security.jwt;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.libre.admin.common.config.LibreSecurityProperties;
import com.libre.admin.module.security.auth.AuthUser;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.Objects;

/**
 * @author ZC
 * @date 2021/7/12 10:41
 */
@Service
@RequiredArgsConstructor
public class JwtTokenService implements SmartInitializingSingleton {

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    private final LibreSecurityProperties properties;
    private JwtParser jwtParser;

    /**
     * 获取用户身份信息
     * @param request request
     * @return 用户信息
     */
    public String getSubject(HttpServletRequest request) {
        String token = getToken(request);
        return getSubject(token);
    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public String getSubject(String token) {
        if (StrUtil.isBlank(token)) {
            return null;
        }

        Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        if (Objects.isNull(body)) {
            return null;
        }
        return body.getSubject();
    }

    public String getToken(HttpServletRequest request) {
        Objects.requireNonNull(properties, "LibreSecurityProperties must not be null");
        LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
        String tokenHeaderKey = jwtToken.getHeader();
        String token = request.getHeader(tokenHeaderKey);
        if (StrUtil.isBlank(token)) {
            token = request.getParameter(tokenHeaderKey);
        }

        if (StrUtil.isNotBlank(token) && token.startsWith(TOKEN_PREFIX)) {
            token = token.substring(TOKEN_PREFIX.length());
        }

        if (StrUtil.isBlank(token)) {
            return null;
        }
        return token;
    }

    public String createToken(AuthUser authUser, Date now, Duration expireTime) {
        Objects.requireNonNull(properties, "LibreSecurityProperties must not be null");
        LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
        SignatureAlgorithm algorithm = jwtToken.getSignatureAlgorithm();

        return Jwts.builder()
                .setId(IdWorker.get32UUID())
                .setAudience(jwtToken.getAudience())
                .setIssuer(jwtToken.getIssuer())
                .setIssuedAt(now)
                .setSubject(authUser.getUsername())
                .setNotBefore(now)
                .setExpiration(plus(now, expireTime))
                .signWith(getKey(), algorithm)
                .compact();
    }



    private  Key getKey() {
        LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
        String secret = jwtToken.getSecret();
        SignatureAlgorithm algorithm = jwtToken.getSignatureAlgorithm();
        return new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), algorithm.getJcaName());
    }

    /**
     * 日期添加时间量
     *
     * @param date   时间
     * @param amount 时间量
     * @return 设置后的时间
     */
    private Date plus(Date date, TemporalAmount amount) {
        Objects.requireNonNull(date, "The date must not be null");
        Instant instant = date.toInstant()
                .plus(amount);
        return Date.from(instant);
    }

    @Override
    public void afterSingletonsInstantiated() {
        Key key = getKey();
        jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

    }
}
