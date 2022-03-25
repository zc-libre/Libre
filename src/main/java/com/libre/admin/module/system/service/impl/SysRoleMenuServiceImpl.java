package com.libre.admin.module.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.module.system.entity.SysRoleMenu;
import com.libre.admin.module.system.mapper.RoleMenuMapper;
import com.libre.admin.module.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZC
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Override
    public List<SysRoleMenu> getListByRoleIds(Collection<Long> roleIds) {
        return super.list(Wrappers.<SysRoleMenu>lambdaQuery()
                .in(SysRoleMenu::getRoleId, roleIds));
    }

    @Override
    public List<Long> getIdListByRoleIds(Collection<Long> roleIds) {
        List<SysRoleMenu> roleMenuList = this.getListByRoleIds(roleIds);
        if (CollUtil.isEmpty(roleMenuList)) {
            return Collections.emptyList();
        }
        return roleMenuList.stream()
                .map(SysRoleMenu::getMenuId)
                .distinct()
                .collect(Collectors.toList());
    }
}
