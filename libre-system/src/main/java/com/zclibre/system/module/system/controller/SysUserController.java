package com.zclibre.system.module.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.toolkit.result.R;
import com.zclibre.system.module.system.pojo.dto.UserCriteria;
import com.zclibre.system.module.system.pojo.entity.SysUser;
import com.zclibre.system.module.system.pojo.vo.UserVO;
import com.zclibre.system.module.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhao.cheng
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/sys/user")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    @ApiOperation("用户列表")
    @PostMapping("/list")
    public R<PageDTO<UserVO>> list(Page<SysUser> page, UserCriteria param) {
        PageDTO<UserVO> userPage = sysUserService.findByPage(page, param);
        return R.data(userPage);
    }

    @ApiOperation("获取用户")
    @GetMapping("/{id}")
    public R info(@PathVariable Long id) {
        return R.data(sysUserService.findUserById(id));
    }


}
