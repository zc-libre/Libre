package com.libre.admin.module.system.service;

import com.libre.admin.module.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * @author zhao.cheng
 */
public interface SysRoleService extends IService<SysRole>{

    /**
     * 根据用户 id 获取角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<SysRole> getListByUserId(Long userId);


    /**
     * 更新角色菜单
     *
     * @param role    角色
     * @param menuIds 菜单列表
     * @return 是否成功
     */
    boolean updateMenus(SysRole role, List<Long> menuIds);

    /**
     * 如果没有使用，删除
     *
     * @param ids id 集合
     * @return 是否成功
     */
    boolean deleteIfUnusedByIds(Collection<Long> ids);

    /**
     * 保存角色
     *
     * @param entity            实体
     * @param isDataScopeCustom 是否自定义数据权限
     * @param deptList          部门列表
     * @return 是否成功
     */
    boolean saveRole(SysRole entity, boolean isDataScopeCustom, List<Long> deptList);

    /**
     * 更新角色
     *
     * @param entity            实体
     * @param isDataScopeCustom 是否自定义数据权限
     * @param deptList          部门列表
     * @return 是否成功
     */
    boolean updateRoleById(SysRole entity, boolean isDataScopeCustom, List<Long> deptList);
}
