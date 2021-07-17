package com.libre.admin.project.system.service;

import com.libre.admin.project.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author zhao.cheng
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过id查找用户
     *
     * @param id /
     * @return /
     */
    SysUser findUserById(Long id);

    /**
     * 根据登录名查找用户
     *
     * @param username 登录名
     * @return 用户
     */
    SysUser getByUsername(String username);
}
