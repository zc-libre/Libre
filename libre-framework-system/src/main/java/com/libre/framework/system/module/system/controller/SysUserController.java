package com.libre.framework.system.module.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.system.module.security.constant.SecurityConstant;
import com.libre.framework.system.module.system.pojo.dto.UserDTO;
import com.libre.framework.system.module.system.pojo.entity.SysUser;
import com.libre.framework.system.module.system.service.SysUserService;
import com.libre.toolkit.core.StringPool;
import com.libre.toolkit.core.StringUtil;
import com.libre.toolkit.result.R;
import com.libre.framework.system.module.system.pojo.dto.UserCriteria;
import com.libre.framework.system.module.system.pojo.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * @author zhao.cheng
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/sys/user")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    private final PasswordEncoder passwordEncoder;

    @ApiOperation("用户列表")
    @PostMapping("/list")
    public R<PageDTO<UserVO>> list(Page<SysUser> page, UserCriteria param) {
        PageDTO<UserVO> userPage = sysUserService.findByPage(page, param);
        return R.data(userPage);
    }


    @ApiOperation("获取用户")
    @GetMapping("/{id}")
    public R<SysUser> info(@PathVariable Long id) {
        return R.data(sysUserService.findUserById(id));
    }

    @PutMapping("/save")
    public R<Boolean> save(UserDTO user) {
        String password = passwordEncoder.encode("123456");

        user.setPassword(password.replace(SecurityConstant.PASSWORD_PREFIX, StringPool.EMPTY));
        boolean res = sysUserService.createUser(user);
        return R.status(res);
    }

    @PostMapping("edit")
    public R<Boolean> update(UserDTO user) {
        boolean res = sysUserService.updateUser(user);
        return R.status(res);
    }
    @DeleteMapping
    public R<Boolean> delete(@NotEmpty @RequestBody Set<Long> ids) {
        boolean res = sysUserService.deleteUserByIds(ids);
        return R.status(res);
    }
}
