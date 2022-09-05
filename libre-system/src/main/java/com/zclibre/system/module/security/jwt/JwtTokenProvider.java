package com.zclibre.system.module.security.jwt;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import com.google.common.base.Charsets;
import com.libre.redis.cache.RedisUtils;
import com.zclibre.system.config.LibreSecurityProperties;
import com.zclibre.system.module.security.pojo.dto.AuthUser;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * @author /
 */
@Slf4j
@Component
public class JwtTokenProvider implements InitializingBean {
    private static final String AUTHORITIES_KEY = "user";
    private final LibreSecurityProperties properties;
    private final RedisUtils redisUtils;
    private final UserDetailsService userDetailsService;
    private JwtParser jwtParser;
    private JwtBuilder jwtBuilder;



    public JwtTokenProvider(LibreSecurityProperties properties, RedisUtils redisUtils, UserDetailsService userDetailsService) {
        this.properties = properties;
        this.redisUtils = redisUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void afterPropertiesSet() {
        LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
        String secret = jwtToken.getSecret();
        SignatureAlgorithm algorithm = jwtToken.getSignatureAlgorithm();
        // 加密 key
        Key key = new SecretKeySpec(secret.getBytes(Charsets.UTF_8), algorithm.getJcaName());

        jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        this.jwtBuilder = Jwts.builder()
                .setAudience(jwtToken.getAudience())
                .setIssuer(jwtToken.getIssuer())
                .signWith(key, algorithm);
    }

    /**
     * 创建Token 设置永不过期，
     * Token 的时间有效性转到Redis 维护
     *
     * @param authentication /
     * @return /
     */
    public String createToken(Authentication authentication) {
        return jwtBuilder
                // 加入ID确保生成的 Token 都不一致
                .setId(IdWorker.get32UUID())
                .claim(AUTHORITIES_KEY, authentication.getName())
                .setSubject(authentication.getName())
                .compact();
    }

    /**
     * 依据Token 获取鉴权信息
     *
     * @param token /
     * @return /
     */
    Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        AuthUser authUser = Objects.requireNonNull((AuthUser) userDetailsService.loadUserByUsername(claims.getSubject()));
        return new UsernamePasswordAuthenticationToken(authUser, token, authUser.getAuthorities());
    }


    public Claims getClaims(String token) {
        return jwtParser
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * @param token 需要检查的token
     */
    public void checkRenewal(String token) {
        LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
        String storePrefix = jwtToken.getStorePrefix();
        String cacheKey = storePrefix + token;
        RedisTemplate<String, Object> redisTemplate = redisUtils.getRedisTemplate();
        Long expire = redisTemplate.getExpire(cacheKey);
        LocalDateTime expireDateTime = LocalDateTime.now().plus(Objects.requireNonNull(expire), ChronoUnit.MILLIS);
        Duration duration = Duration.between(LocalDateTime.now(), expireDateTime);

        if (duration.compareTo(jwtToken.getDetectTime()) <= 0) {
            Duration newExpireTime = jwtToken.getRenewTime().plusMillis(expire);
            redisUtils.expire(cacheKey, newExpireTime);
        }
    }

    public String getToken(HttpServletRequest request) {
        LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
        final String requestHeader = request.getHeader(jwtToken.getHeader());
        if (requestHeader != null && requestHeader.startsWith(jwtToken.getStorePrefix())) {
            return requestHeader.substring(7);
        }
        return null;
    }
}
