package com.libre.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.common.security.model.SecurityUser;
import com.libre.module.system.entity.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/
public interface RoleService extends IService<Role>{

    /**
     * 获取用户权限信息
     * @param user /
     * @return /
     */
    List<GrantedAuthority> mapToGrantedAuthorities(SecurityUser user);
}
