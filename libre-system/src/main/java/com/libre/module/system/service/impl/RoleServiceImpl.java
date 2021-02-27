package com.libre.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.common.security.model.SecurityUser;
import com.libre.module.system.entity.Role;
import com.libre.module.system.mapper.RoleMapper;
import com.libre.module.system.service.RoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<GrantedAuthority> mapToGrantedAuthorities(SecurityUser user) {
        return null;
    }
}
