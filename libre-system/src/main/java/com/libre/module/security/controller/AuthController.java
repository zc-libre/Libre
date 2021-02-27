package com.libre.module.security.controller;

import com.libre.common.annotation.AnonymousAccess;
import com.libre.common.security.model.JwtUser;
import com.libre.common.security.prop.SecurityProperties;
import com.libre.common.security.util.JwtUtils;
import com.libre.common.tookit.Builder;
import com.libre.common.tookit.result.R;
import com.libre.module.security.service.OnlineUserService;
import com.libre.module.security.service.dto.AuthUserDTO;
import com.libre.module.security.vo.LoginUserVO;
import com.libre.module.security.vo.UserVO;
import com.libre.module.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhao.cheng
 * @Date 2021/2/18
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserService userService;

    @AnonymousAccess
    @PostMapping("/token")
    public R<LoginUserVO> login(@RequestBody AuthUserDTO authUser, HttpServletRequest request) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌
        String token = JwtUtils.createToken(authentication);
        final JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        // 保存在线信息
        onlineUserService.save(jwtUser, token, request);

        // 返回 token 与 用户信息
        LoginUserVO loginUserVO = Builder.of(LoginUserVO::new)
                .with(LoginUserVO::setToken, properties.getTokenStartWith() + token)
                .with(LoginUserVO::setUser, jwtUser)
                .build();

        return R.data(loginUserVO);
    }

    @GetMapping("/info")
    public R<UserVO> getInfo() {
       return null;
    }

}
