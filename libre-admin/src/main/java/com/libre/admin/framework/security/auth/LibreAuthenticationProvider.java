package com.libre.admin.framework.security.auth;

import cn.hutool.core.util.StrUtil;
import com.libre.admin.framework.config.LibreSecurityProperties;
import com.libre.admin.framework.security.service.UserDetailServiceImpl;
import com.libre.admin.framework.security.service.UserLockService;
import com.libre.boot.exception.ServiceException;
import com.libre.captcha.service.CaptchaService;
import com.libre.core.result.ResultCode;
import com.libre.core.toolkit.RsaUtil;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZC
 * @date 2021/7/13 13:26
 */

public class LibreAuthenticationProvider extends DaoAuthenticationProvider {

    private  LibreSecurityProperties properties;
    private CacheManager cacheManager;
    private Cache passwordRetryCache;
    private CaptchaService captchaService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.isAuthenticated()) {
            return authentication;
        }
        LibreWebAuthenticationDetails details = (LibreWebAuthenticationDetails) authentication.getDetails();
        String validateCode = details.getValidateCode();
        if (StrUtil.isBlank(validateCode)) {
            throw new ServiceException(ResultCode.PARAM_MISS, "请填写验证码");
        }
        String validateCodeId = details.getValidateCodeId();
        if (StrUtil.isBlank(validateCodeId)) {
            throw new ServiceException(ResultCode.PARAM_MISS, "验证码UUID为空");
        }

        boolean validate = captchaService.validate(validateCodeId, validateCode);
        if (!validate) {
            throw new ServiceException(ResultCode.PARAM_VALID_ERROR, "验证码已失效");
        }
        UsernamePasswordAuthenticationToken auth;
        try {
            auth = decodeRsaPassword(authentication);
        }catch (Throwable t) {
            throw new ServiceException(ResultCode.PARAM_VALID_ERROR, "密码被篡改，解密失败");
        }
        return super.authenticate(auth);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String username = userDetails.getUsername();
        AtomicInteger retryCount = passwordRetryCache.get(username, AtomicInteger.class);
        if (Objects.isNull(retryCount)) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        int retryLimit = properties.getLogin().getRetryLimit();
        if (retryCount.incrementAndGet() > retryLimit) {
            logger.warn("username: " + username + " tried to login more than " + retryLimit + " times in period");
            UserLockService userLockService = this.getUserLockService();
            userLockService.updateLockUser((AuthUser) userDetails);
            throw new ServiceException(ResultCode.PARAM_VALID_ERROR, "登录错误" + retryCount + "次，账号已锁定");
        } else {
            passwordRetryCache.put(username, retryCount);
        }
        super.additionalAuthenticationChecks(userDetails, authentication);
        //clear retry data
        passwordRetryCache.evict(username);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    protected void doAfterPropertiesSet() {
        super.doAfterPropertiesSet();
        Assert.notNull(properties, "dreamProperties is null");
        Assert.notNull(cacheManager, "cacheManager is null");
        String retryLimitCacheName = properties.getLogin().getRetryLimitCacheName();
        this.passwordRetryCache = cacheManager.getCache(retryLimitCacheName);
        Assert.notNull(this.passwordRetryCache, "retryLimitCache retryLimitCacheName: " + retryLimitCacheName + " is not config.");
        //  Assert.notNull(captchaService, "captchaService is null");
    }

    private UsernamePasswordAuthenticationToken decodeRsaPassword(Authentication auth) {
        Object credentials = auth.getCredentials();
        String privateBase64 = properties.getLoginKeyPair().getPrivateBase64();
        String decryptPwd = RsaUtil.decryptFromBase64(privateBase64, (String) credentials);
        UsernamePasswordAuthenticationToken newToken = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), decryptPwd);
        newToken.setDetails(auth.getDetails());
        return newToken;
    }

    private UserDetailServiceImpl getUserLockService() {
        UserDetailsService userDetailsService = super.getUserDetailsService();
        return (UserDetailServiceImpl) userDetailsService;
    }

    public LibreSecurityProperties getProperties() {
        return properties;
    }

    public void setProperties(LibreSecurityProperties properties) {
        this.properties = properties;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public Cache getPasswordRetryCache() {
        return passwordRetryCache;
    }

    public void setPasswordRetryCache(Cache passwordRetryCache) {
        this.passwordRetryCache = passwordRetryCache;
    }

    public CaptchaService getCaptchaService() {
        return captchaService;
    }

    public void setCaptchaService(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }
}
