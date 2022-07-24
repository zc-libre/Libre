package com.libre.system.module.security.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import com.libre.system.config.LibreSecurityProperties;
import com.libre.system.module.security.jwt.TokenProvider;
import com.libre.system.module.security.pojo.RoleInfo;
import com.libre.system.module.security.service.OnlineUserService;
import com.libre.system.module.security.service.UserLockService;
import com.libre.system.module.security.service.dto.AuthUser;
import com.libre.system.module.security.service.dto.AuthUserDTO;
import com.libre.system.module.system.entity.SysMenu;
import com.libre.system.module.system.service.SysMenuService;
import com.libre.system.module.system.utils.MenuUtil;
import com.libre.system.module.system.vo.JwtUserVO;
import com.libre.system.module.system.vo.MenuVO;
import com.libre.captcha.service.CaptchaService;
import com.libre.captcha.vo.CaptchaVO;
import com.libre.toolkit.exception.LibreException;
import com.libre.toolkit.result.R;
import com.libre.toolkit.result.ResultCode;
import com.libre.toolkit.core.StringUtil;
import com.libre.redis.cache.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.undertow.util.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Libre
 * @date 2021/7/12 17:54
 */
@Slf4j
@Api(tags = "授权管理")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

    private final LibreSecurityProperties properties;
    private final SysMenuService menuService;
    private final CaptchaService captchaService;
    private final RedisUtils redisUtils;
    private final OnlineUserService onlineUserService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserLockService userLockService;

    @GetMapping("/captcha")
    public R<CaptchaVO> captcha() {
        CaptchaVO captchaVO = captchaService.generateBase64Vo(IdWorker.get32UUID());
        return R.data(captchaVO);
    }



    @ApiOperation("登录")
    @PostMapping("/token")
    public R<Boolean> login(@Validated @RequestBody AuthUserDTO authUser, HttpServletRequest request) throws BadRequestException {

        if (StringUtil.isBlank(authUser.getCode()) || captchaService.validate(authUser.getUuid(), authUser.getCode())) {
            throw new BadRequestException("验证码错误");
        }

        String password = authUser.getPassword();

        String retryLimitCacheName = properties.getLogin().getRetryLimitCacheName();
        String username = authUser.getUsername();
        retryLimitCacheName = retryLimitCacheName + username;
        Integer retryCount = redisUtils.get(retryLimitCacheName);
        if (null == retryCount) {
            retryCount = 1;
            redisUtils.set(retryLimitCacheName, retryCount);
        }
        int retryLimit = properties.getLogin().getRetryLimit();
        if (retryCount > retryLimit) {
            log.warn("username: " + username + " tried to login more than " + retryLimit + " times in period");
            userLockService.updateLockUser(authUser);
            throw new LibreException("登录错误" + retryCount + "次，账号已锁定");
        } else {
            redisUtils.incr(retryLimitCacheName);
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authUser.getUsername(), password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        final AuthUser jwtUserDto = (AuthUser) authentication.getPrincipal();
        // 保存在线信息
        onlineUserService.save(jwtUserDto, token, request);
        redisUtils.del(retryLimitCacheName);
        return R.success(ResultCode.SUCCESS);
    }


    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public R<JwtUserVO> getUserInfo(AuthUser authUser) {
        JwtUserVO userVO = new JwtUserVO();
        userVO.setUserInfo(authUser.toJwtUser());
        return R.data(userVO);
    }


    @ApiOperation("退出登录")
    @DeleteMapping(value = "/logout")
    public R<Boolean> logout(HttpServletRequest request) {
        String token = tokenProvider.getToken(request);
        onlineUserService.removeByToken(token);
        return R.data(Boolean.TRUE);
    }

    @GetMapping("/menus")
    public R<List<MenuVO>> getMenus(AuthUser user) {
        if (Boolean.TRUE.equals(user.getIsAdmin())) {
            List<SysMenu> menuList = menuService.getAllMenu();
            return R.data(MenuUtil.transform(menuList));
        }
        List<RoleInfo> roleList = user.getRoleList();
        if (CollectionUtils.isEmpty(roleList)) {
            return R.data(Collections.emptyList());
        }
        Set<Long> roleIds = roleList.stream()
                .map(RoleInfo::getId)
                .collect(Collectors.toSet());
        List<SysMenu> menuList = menuService.getNavByRoleIds(roleIds);
        return R.data(MenuUtil.transform(menuList));
    }
}
