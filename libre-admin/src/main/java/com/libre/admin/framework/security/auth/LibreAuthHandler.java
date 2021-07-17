package com.libre.admin.framework.security.auth;

import com.libre.admin.framework.config.LibreSecurityProperties;
import com.libre.admin.framework.security.jwt.JwtTokenService;
import com.libre.admin.framework.security.jwt.JwtTokenStore;
import com.libre.admin.framework.security.jwt.JwtUser;
import com.libre.admin.framework.security.utils.SecurityUtil;
import com.libre.admin.framework.vo.JwtUserVO;
import com.libre.core.result.R;
import com.libre.core.toolkit.WebUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

/**
 * @author ZC
 * @date 2021/7/12 16:07
 */
@Slf4j
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class LibreAuthHandler extends AccessDeniedHandlerImpl implements AuthenticationSuccessHandler, AuthenticationFailureHandler, LogoutSuccessHandler {

    private final JwtTokenService tokenService;
    private final JwtTokenStore tokenStore;
    private final LibreSecurityProperties properties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (response.isCommitted()) {
            return;
        }
        // 没有权限 403
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        WebUtil.renderJson(response, R.fail("没有权限访问"));
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LibreWebAuthenticationDetails details = (LibreWebAuthenticationDetails) authentication.getDetails();
        AuthUser authUser = SecurityUtil.getUser(authentication);
        Date now = new Date();
        LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
        Duration expireTime = details.isRememberMe() ? jwtToken.getRememberMeTime() : jwtToken.getExpireTime();
        Assert.notNull(authUser, "authUser is null!");
        String token = tokenService.createToken(authUser, now, expireTime);
        tokenStore.save(request, authUser, token, expireTime);
        JwtUserVO jwtUserVO = getJwtUserVO(token, authUser.toJwtUser(), properties.getUserKeyPair().getPublicBase64());
        WebUtil.renderJson(response, jwtUserVO);
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = tokenService.getToken(request);
        // 删除 token
        tokenStore.removeByToken(token);
    }

    private JwtUserVO getJwtUserVO(String token, JwtUser jwtUser, String publicKey) {
        JwtUserVO userVO = new JwtUserVO();
        userVO.setToken(token);
        userVO.setUserInfo(jwtUser);
        userVO.setPublicKey(publicKey);
        return userVO;
    }
}
