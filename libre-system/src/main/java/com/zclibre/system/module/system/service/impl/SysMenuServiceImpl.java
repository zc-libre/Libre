package com.zclibre.system.module.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zclibre.common.constant.LibreConstants;
import com.zclibre.system.module.system.entity.SysMenu;
import com.zclibre.system.module.system.mapper.SysMenuMapper;
import com.zclibre.system.module.system.service.SysMenuService;
import com.zclibre.system.module.system.service.SysRoleMenuService;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Libre
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private final SysRoleMenuService roleMenuService;

    @Override
    public List<SysMenu> getListByRoleIds(Set<Long> roleIds) {
        List<Long> roleMenuIdList = roleMenuService.getIdListByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleMenuIdList)) {
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
        if (CollectionUtils.isEmpty(roleMenuIdList)) {
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
