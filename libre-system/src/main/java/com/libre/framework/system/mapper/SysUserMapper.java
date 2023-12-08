package com.libre.framework.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libre.framework.system.pojo.entity.SysUser;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author zhao.cheng
 */
public interface SysUserMapper extends BaseMapper<SysUser> {


    void saveBatch(Collection<SysUser> sysUsers);
}
