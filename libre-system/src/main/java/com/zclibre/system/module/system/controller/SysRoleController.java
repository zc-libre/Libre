package com.zclibre.system.module.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.toolkit.result.R;
import com.zclibre.system.module.system.pojo.dto.RoleCriteria;
import com.zclibre.system.module.system.pojo.entity.SysRole;
import com.zclibre.system.module.system.pojo.vo.RoleVO;
import com.zclibre.system.module.system.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Libre
 * @Date: 2022/9/4 5:05 PM
 */
@RestController
@RequestMapping("/sys/role")
@RequiredArgsConstructor
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @ApiOperation("用户列表")
    @PostMapping("/list")
    public R<PageDTO<RoleVO>> list(Page<SysRole> page, RoleCriteria roleCriteria) {
        PageDTO<RoleVO> rolePage  = sysRoleService.findByPage(page, roleCriteria);
        return R.data(rolePage);
    }
}
