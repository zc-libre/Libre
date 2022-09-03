package com.zclibre.system.module.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zclibre.system.module.system.pojo.entity.SysUser;
import com.zclibre.system.module.system.pojo.dto.UserCriteria;
import com.zclibre.system.module.system.service.SysUserService;
import com.zclibre.system.module.system.pojo.vo.UserVO;
import com.libre.toolkit.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping
    public R<IPage<UserVO>> list(Page<SysUser> page, UserCriteria param) {
        IPage<UserVO> userPage = sysUserService.findByPage(page, param);
        return R.data(userPage);
    }

    @ApiOperation("获取用户")
    @GetMapping("/{id}")
    public R info(@PathVariable Long id) {
        return R.data(sysUserService.findUserById(id));
    }


}
