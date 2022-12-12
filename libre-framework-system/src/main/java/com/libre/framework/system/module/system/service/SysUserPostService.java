package com.libre.framework.system.module.system.service;

import com.libre.framework.system.module.system.pojo.entity.SysUserPost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
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

    /**
     * 根据用户id查找
     * @param userIds userIds
     * @return List<SysUserPost>
     */
    List<SysUserPost> getListByUserIds(Collection<Long> userIds);
}
