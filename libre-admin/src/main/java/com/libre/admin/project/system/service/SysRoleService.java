package com.libre.admin.project.system.service;

import com.libre.admin.project.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
