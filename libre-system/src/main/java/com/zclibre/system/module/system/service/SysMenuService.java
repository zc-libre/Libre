package com.zclibre.system.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zclibre.system.module.system.pojo.entity.SysMenu;
import com.zclibre.system.module.system.pojo.vo.MenuVO;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author zhao.cheng
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 根据角色 id 列表查找菜单
     *
     * @param roleIds 角色id
     * @return 菜单列表
     */
    List<SysMenu> getListByRoleIds(Collection<Long> roleIds);

    /**
     * 超级管理员获取所有菜单
     *
     * @return 菜单列表
     */
    List<SysMenu> getAllMenu();

    /**
     * 根据角色 id 列表查找导航的菜单
     *
     * @param roleIds 角色id
     * @return 菜单列表
     */
    List<SysMenu> getNavByRoleIds(Collection<Long> roleIds);

    /**
     * 添加菜单
     * @param menu menu
     * @return /
     */
    boolean add(SysMenu menu);

    List<SysMenu> getSuperior(List<Long> ids);


    boolean deleteByIds(List<Long> ids);

}
