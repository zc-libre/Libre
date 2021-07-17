package com.libre.admin.project.system.service;

import com.libre.admin.project.system.entity.SysUserPost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author zhao.cheng
 */
public interface SysUserPostService extends IService<SysUserPost>{

    /**
     * 根据用户id查找
     *
     * @param userId 用户id
     * @return 集合
     */
    List<SysUserPost> getListByUserId(Long userId);
}
