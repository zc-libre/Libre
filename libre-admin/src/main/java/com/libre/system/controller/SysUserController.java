package com.libre.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.libre.core.result.R;
import com.libre.core.toolkit.JsonUtil;
import com.libre.system.service.SysUserService;
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
@RequestMapping("/user")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    @ApiOperation("用户列表")
    @GetMapping
    public R list() {
        return R.data(sysUserService.list());
    }

    @ApiOperation("用户列表")
    @GetMapping("/{id}")
    public R info(@PathVariable Long id) {
        return R.data(sysUserService.findUserById(id));
    }

    @GetMapping("/page")
    public R page(Page page) {
        System.out.println(JsonUtil.toJson(page));
        return R.data(page);
    }
}
