package com.zclibre.system.module.system.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zclibre.system.module.system.constant.RoleConstants;
import com.zclibre.system.module.system.pojo.entity.SysRole;
import com.zclibre.system.module.system.pojo.entity.SysUserRole;
import com.zclibre.system.module.system.mapper.SysRoleMapper;
import com.zclibre.system.module.system.service.SysRoleDeptService;
import com.zclibre.system.module.system.service.SysRoleMenuService;
import com.zclibre.system.module.system.service.SysRoleService;
import com.zclibre.system.module.system.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhao.cheng
 */
@Service
@RequiredArgsConstructor
public class SysSysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private final SysUserRoleService userRoleService;
    private final SysRoleMenuService roleMenuService;
    private final SysRoleDeptService roleDeptService;

    @Override
    public List<SysRole> getListByUserId(Long userId) {
        List<SysUserRole> userRoleList = userRoleService.getListByUserId(userId);
        if (CollectionUtils.isEmpty(userRoleList)) {
            return Collections.emptyList();
        }
        Set<Long> roleIds = userRoleList.stream()
                .map(SysUserRole::getRoleId)
                .collect(Collectors.toSet());

        return this.list(Wrappers.<SysRole>lambdaQuery()
                .in(SysRole::getId, roleIds)
                .eq(SysRole::getStatus, RoleConstants.ROLE_ENABLE));
    }

    @Override
    public boolean updateMenus(SysRole role, List<Long> menuIds) {
        return false;
    }

    @Override
    public boolean deleteIfUnusedByIds(Collection<Long> ids) {
        return false;
    }

    @Override
    public boolean saveRole(SysRole entity, boolean isDataScopeCustom, List<Long> deptList) {
        return false;
    }

    @Override
    public boolean updateRoleById(SysRole entity, boolean isDataScopeCustom, List<Long> deptList) {
        return false;
    }
}
