package com.libre.admin.project.system.service;

import com.libre.admin.project.system.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
