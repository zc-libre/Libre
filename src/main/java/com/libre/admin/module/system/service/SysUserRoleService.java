package com.libre.admin.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.admin.module.system.entity.SysUserRole;

import java.util.Collection;
import java.util.List;

/**
 * @author zhao.cheng
 */
public interface SysUserRoleService extends IService<SysUserRole>{

    /**
     * 根据用户id获取用户角色关系列表
     *
     * @param userId 用户id
     * @return 用户角色关系列表
     */
    List<SysUserRole> getListByUserId(Long userId);

    /**
     * 根据用户id获取用户角色关系列表
     *
     * @param userIds 用户id
     * @return 用户角色关系列表
     */
    List<SysUserRole> getListByUserIds(Collection<Long> userIds);
}
