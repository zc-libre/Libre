package com.libre.admin.project.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.common.constant.LibreConstants;
import com.libre.admin.project.system.entity.SysMenu;
import com.libre.admin.project.system.mapper.MenuMapper;
import com.libre.admin.project.system.service.SysMenuService;
import com.libre.admin.project.system.service.SysRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author ZC
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<MenuMapper, SysMenu> implements SysMenuService {

    private final SysRoleMenuService roleMenuService;

    @Override
    public List<SysMenu> getListByRoleIds(Set<Long> roleIds) {
        List<Long> roleMenuIdList = roleMenuService.getIdListByRoleIds(roleIds);
        if (CollUtil.isEmpty(roleMenuIdList)) {
            return Collections.emptyList();
        }
        return super.listByIds(roleMenuIdList);
    }

    @Override
    public List<SysMenu> getAllMenu() {
        return super.list(Wrappers.<SysMenu>lambdaQuery()
                // 菜单类型（0目录 1菜单 2按钮）
                .in(SysMenu::getType, 0, 1)
                .eq(SysMenu::getHidden, Boolean.FALSE)
                .eq(SysMenu::getStatus, LibreConstants.STATUS_ON)
        );
    }

    @Override
    public List<SysMenu> getNavByRoleIds(Collection<Long> roleIds) {
        List<Long> roleMenuIdList = roleMenuService.getIdListByRoleIds(roleIds);
        if (CollUtil.isEmpty(roleMenuIdList)) {
            return Collections.emptyList();
        }
        return super.list(Wrappers.<SysMenu>lambdaQuery()
                .in(SysMenu::getId, roleMenuIdList)
                // 菜单类型（0目录 1菜单 2按钮）
                .in(SysMenu::getType, 0, 1)
                .eq(SysMenu::getHidden, Boolean.FALSE)
                .eq(SysMenu::getStatus, LibreConstants.STATUS_ON));
    }
}
