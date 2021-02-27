package com.libre.common.security.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.extra.spring.SpringUtil;
import com.libre.common.security.model.JwtUser;
import com.libre.common.security.model.SecurityUser;
import com.libre.common.security.prop.SecurityProperties;
import com.libre.common.tookit.RedisUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.experimental.UtilityClass;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.libre.common.security.constant.TokenConstants.*;

/**
 * @author zhao.cheng
 * @Date 2021/2/28
 */
@UtilityClass
public class JwtUtils {



    private static final SecurityProperties PROPERTIES;
    private static final RedisUtils REDIS_UTILS;
    private static final JwtParser JWT_PARSER;
    private static final JwtBuilder JWT_BUILDER;

    static {
        PROPERTIES = SpringUtil.getBean(SecurityProperties.class);
        REDIS_UTILS = SpringUtil.getBean(RedisUtils.class);

        byte[] keyBytes = Decoders.BASE64.decode(PROPERTIES.getBase64Secret());
        Key key = Keys.hmacShaKeyFor(keyBytes);
        JWT_PARSER = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        JWT_BUILDER = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS512);
    }


    /**
     * 创建Token 设置永不过期，
     * Token 的时间有效性转到Redis 维护
     *
     * @param authentication /
     * @return /
     */
    public String createToken(Authentication authentication) {
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        SecurityUser user = jwtUser.getUserInfo();

        return JWT_BUILDER
                // 加入ID确保生成的 Token 都不一致
                .setId(UUID.fastUUID().toString())
                .claim(USERNAME, user.getUsername())
                .claim(USER_ID, user.getId())
                .claim(NICK_NAME, user.getNickName())
                .claim(ROLES, user.getRoles())
                .claim(DEPT_ID, user.getDeptId())
                .claim(ROLE_ID, user.getRoleIds())
                .claim(POST_ID, user.getPostId())
                .claim(PHONE, user.getPhone())
                .setSubject(authentication.getName())
                .compact();
    }

    /**
     * 依据Token 获取鉴权信息
     * @param token /
     * @return /
     */
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        User principal = new User(claims.getSubject(), "******", new ArrayList<>());
        return new UsernamePasswordAuthenticationToken(principal, token, new ArrayList<>());
    }

    public Claims getClaims(String token) {
        return JWT_PARSER
                .parseClaimsJws(token)
                .getBody();
    }


    public void checkRenewal(String token) {
        // 判断是否续期token,计算token的过期时间
        long time = REDIS_UTILS.getExpire(PROPERTIES.getOnlineKey() + token) * 1000;
        Date expireDate = DateUtil.offset(new Date(), DateField.MILLISECOND, (int) time);
        // 判断当前时间与过期时间的时间差
        long differ = expireDate.getTime() - System.currentTimeMillis();
        // 如果在续期检查的范围内，则续期
        if (differ <= PROPERTIES.getDetect()) {
            long renew = time + PROPERTIES.getRenew();
            REDIS_UTILS.expire(PROPERTIES.getOnlineKey() + token, renew, TimeUnit.MILLISECONDS);
        }
    }

    public String getToken(HttpServletRequest request) {
        final String requestHeader = request.getHeader(PROPERTIES.getHeader());
        if (requestHeader != null && requestHeader.startsWith(PROPERTIES.getTokenStartWith())) {
            return requestHeader.substring(7);
        }
        return null;
    }
}
