package com.libre.admin.framework.security.jwt;

import cn.hutool.core.util.StrUtil;
import com.libre.admin.framework.security.auth.AuthUser;
import com.libre.admin.framework.security.auth.LibreAuthenticationDetailsSource;
import com.libre.admin.framework.security.service.UserDetailServiceImpl;
import com.libre.admin.framework.security.utils.SecurityUtil;
import com.libre.admin.framework.vo.TokenVO;
import com.libre.core.result.R;
import com.libre.core.toolkit.WebUtil;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author ZC
 * @date 2021/7/12 13:42
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final JwtTokenStore jwtTokenStore;
    private final JwtTokenService jwtTokenService;
    private final UserDetailServiceImpl userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenService.getToken(request);
        if (StrUtil.isBlank(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        TokenVO tokenVO = jwtTokenStore.get(token);
        if (Objects.isNull(tokenVO)) {
            // jwt token 解析错误 401
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            WebUtil.renderJson(response, R.fail("请重新登录"));
            return;
        }
        // 判断 token 是否存在
        String subject;
        try {
            subject = jwtTokenService.getSubject(token);
        }catch (JwtException | IllegalArgumentException e) {
            // jwt token 解析错误 401
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            WebUtil.renderJson(response, R.fail("请重新登录"));
            return;
        }
        if (subject != null && SecurityUtil.getAuthentication() == null) {
            AuthUser authUser = (AuthUser) userDetailService.loadUserByUsername(subject);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUser, null, authUser.getAuthorities());
            authenticationToken.setDetails(new LibreAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            jwtTokenStore.checkRenewal(token);
        }
        filterChain.doFilter(request, response);
    }
}
