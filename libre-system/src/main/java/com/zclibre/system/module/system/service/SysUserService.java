package com.zclibre.system.module.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zclibre.system.module.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zclibre.system.module.system.dto.UserCriteria;
import com.zclibre.system.module.system.vo.UserVO;

import java.util.Collection;
import java.util.List;

/**
 * @author zhao.cheng
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 分页查询
     * @param page page
     * @param userParam userParam
     * @return IPage<UserVO>
     */
    IPage<UserVO> findByPage(Page<SysUser> page, UserCriteria userParam);

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



    /**
     * 按照用户账号更新
     * @param sysUser 用户
     */
    boolean updateByUsername(String username, SysUser sysUser);
}
