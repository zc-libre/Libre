package com.libre.system.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.system.entity.SysUser;
import com.libre.system.mapper.UserMapper;
import com.libre.system.service.SysUserService;


/**
 * @author zhao.cheng
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements SysUserService {

    @Override
    @Cacheable(cacheNames = "user", key = "#id")
    public SysUser findUserById(Long id) {
        return baseMapper.selectById(id);
    }
}
