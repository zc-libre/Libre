package com.libre.admin.module.security.jwt;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.libre.admin.common.config.LibreSecurityProperties;
import com.libre.admin.module.security.auth.AuthUser;
import com.libre.admin.module.security.pojo.DeptInfo;
import com.libre.admin.module.system.vo.TokenVO;
import com.libre.core.toolkit.CharPool;
import com.libre.core.toolkit.DesensitizationUtil;
import com.libre.core.toolkit.StringPool;
import com.libre.core.toolkit.WebUtil;
import com.libre.redis.cache.RedisUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ZC
 * @date 2021/7/12 12:05
 */
@Component
public class JwtTokenStore {

    private final RedisUtils redisUtils;
    private final LibreSecurityProperties.JwtToken jwtTokenProperties;

    public JwtTokenStore(RedisUtils redisUtils,
                         LibreSecurityProperties jwtTokenProperties) {
        this.redisUtils = redisUtils;
        this.jwtTokenProperties = jwtTokenProperties.getJwtToken();
    }

    public TokenVO get(String token) {
       return redisUtils.get(getCacheKeyByToken(token));
    }

    public void save(HttpServletRequest request, AuthUser authUser, String token, Duration expireTime) {
        String storePrefix = jwtTokenProperties.getStorePrefix();
        String key = DigestUtil.md5Hex(token);
        String ip = WebUtil.getIP(request);
        UserAgent userAgent = UserAgentUtil.parse(request.getHeader(HttpHeaders.USER_AGENT));
        String browser = userAgent.getBrowser().getName();
        TokenVO tokenVO = new TokenVO();
        tokenVO.setUserName(authUser.getUsername());
        tokenVO.setNickName(authUser.getNickName());
        DeptInfo dept = authUser.getDept();
        if (Objects.nonNull(dept)) {
            tokenVO.setDept(dept.getName());
        }
        tokenVO.setBrowser(browser);
        tokenVO.setIp(ip);

        // TODO 地理位置解析
         tokenVO.setSummary(DesensitizationUtil.sensitive(token, 8, 8, CharPool.DOT, 4));
         tokenVO.setKey(key);
         tokenVO.setLoginTime(LocalDateTime.now());
         String cacheKey = storePrefix + key;
         redisUtils.setEx(cacheKey, tokenVO, expireTime);
    }

    /**
     * token 信息分页
     *
     * @param page   page
     * @param filter 过滤条件
     * @return token 集合
     */
    public Page<TokenVO> page(Page<TokenVO> page, String filter) {
        List<TokenVO> tokenList = getAll(filter);
        page.setRecords(tokenList);
        page.setTotal(tokenList.size());
        return page;
    }

    public List<TokenVO> getAll(String filter) {
        String storePrefix = jwtTokenProperties.getStorePrefix();
        Set<String> tokenSet = redisUtils.scan(storePrefix + StringPool.ASTERISK);
        List<TokenVO> tokenList = Lists.newArrayList();
        for (String cacheKey : tokenSet) {
            TokenVO token = redisUtils.get(cacheKey);
            if (StrUtil.isNotBlank(filter)) {
                Assert.notNull(token, "token is null");
                if (token.toString().contains(filter)) {
                    tokenList.add(token);
                }
            } else {
                tokenList.add(token);
            }
        }
        tokenList.sort(((o1, o2) -> o2.getLoginTime().compareTo(o1.getLoginTime())));
        return tokenList;
    }

    /**
     * 批量移除 token
     * @param keys key 集合
     */
    public void remove(Set<String> keys) {
        String storePrefix = jwtTokenProperties.getStorePrefix();
        keys = keys.stream().map(key -> storePrefix + key).collect(Collectors.toSet());
        redisUtils.del(keys);
    }

    /**
     * 移除token
     * @param token token
     */
    @Async
    public void removeByToken(String token) {
        redisUtils.del(getCacheKeyByToken(token));
    }


    public void checkRenewal(String token) {
        String cacheKey = getCacheKeyByToken(token);
        RedisTemplate<String, Object> redisTemplate = redisUtils.getRedisTemplate();
        Long expire = redisTemplate.getExpire(cacheKey);
        LocalDateTime expireDateTime = LocalDateTime.now().plus(Objects.requireNonNull(expire), ChronoUnit.MILLIS);
        Duration duration = Duration.between(LocalDateTime.now(), expireDateTime);

        if (duration.compareTo(jwtTokenProperties.getDetectTime()) <= 0) {
            Duration newExpireTime = jwtTokenProperties.getRenewTime().plusMillis(expire);
            redisUtils.expire(cacheKey, newExpireTime);
        }
    }

    private String getCacheKeyByToken(String token) {
        String storePrefix = jwtTokenProperties.getStorePrefix();
        String key = DigestUtil.md5Hex(token);
        return storePrefix + key;
    }


}
