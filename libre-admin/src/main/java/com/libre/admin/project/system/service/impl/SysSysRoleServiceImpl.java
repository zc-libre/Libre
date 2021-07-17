package com.libre.admin.project.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.entity.SysRole;
import com.libre.admin.project.system.entity.SysUserRole;
import com.libre.admin.project.system.mapper.RoleMapper;
import com.libre.admin.project.system.service.SysRoleDeptService;
import com.libre.admin.project.system.service.SysRoleMenuService;
import com.libre.admin.project.system.service.SysRoleService;
import com.libre.admin.project.system.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhao.cheng
 */
@Service
@RequiredArgsConstructor
public class SysSysRoleServiceImpl extends ServiceImpl<RoleMapper, SysRole> implements SysRoleService {

    private final SysUserRoleService userRoleService;
    private final SysRoleMenuService roleMenuService;
    private final SysRoleDeptService roleDeptService;

    @Override
    public List<SysRole> getListByUserId(Long userId) {
        List<SysUserRole> userRoleList = userRoleService.getListByUserId(userId);
        if (CollUtil.isEmpty(userRoleList)) {
            return Collections.emptyList();
        }
        Set<Long> roleIds = userRoleList.stream()
                .map(SysUserRole::getRoleId)
                .collect(Collectors.toSet());

        return this.list(Wrappers.<SysRole>lambdaQuery()
                .in(SysRole::getId, roleIds)
                .eq(SysRole::getStatus, Boolean.FALSE));
    }
}
