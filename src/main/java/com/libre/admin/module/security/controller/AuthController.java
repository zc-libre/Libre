package com.libre.admin.module.security.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.libre.admin.common.config.LibreSecurityProperties;
import com.libre.admin.module.security.auth.AuthUser;
import com.libre.admin.module.security.pojo.RoleInfo;
import com.libre.admin.module.system.utils.MenuUtil;
import com.libre.admin.module.system.vo.JwtUserVO;
import com.libre.admin.module.system.vo.MenuVO;
import com.libre.admin.module.system.entity.SysMenu;
import com.libre.admin.module.system.service.SysMenuService;
import com.libre.captcha.service.CaptchaService;
import com.libre.captcha.vo.CaptchaVO;
import com.libre.core.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ZC
 * @date 2021/7/12 17:54
 */
@Api(tags = "授权管理")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LibreSecurityProperties properties;
    private final SysMenuService menuService;
    private final CaptchaService captchaService;

    @GetMapping("/captcha")
    public R captcha() {
        CaptchaVO captchaVO = captchaService.generateBase64Vo(IdWorker.get32UUID());
        return R.data(captchaVO);
    }

    @ApiOperation("密码加密公钥")
    @GetMapping("/public-key")
    public String getPublicKey() {
        return properties.getLoginKeyPair().getPublicBase64();
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public R<JwtUserVO> getUserInfo(AuthUser authUser) {
        JwtUserVO userVO = new JwtUserVO();
        userVO.setUserInfo(authUser.toJwtUser());
        userVO.setPublicKey(properties.getUserKeyPair().getPublicBase64());
        return R.data(userVO);
    }

    @GetMapping("/menus")
    public R<List<MenuVO>> getMenus(AuthUser user) {
        if (Boolean.TRUE.equals(user.getIsAdmin())) {
            List<SysMenu> menuList = menuService.getAllMenu();
            return R.data(MenuUtil.transform(menuList));
        }
        List<RoleInfo> roleList = user.getRoleList();
        if (CollUtil.isEmpty(roleList)) {
            return R.data(Collections.emptyList());
        }
        Set<Long> roleIds = roleList.stream()
                .map(RoleInfo::getId)
                .collect(Collectors.toSet());
        List<SysMenu> menuList = menuService.getNavByRoleIds(roleIds);
        return R.data(MenuUtil.transform(menuList));
    }
}
