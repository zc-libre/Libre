package com.libre.admin.project.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.entity.SysUserRole;
import com.libre.admin.project.system.mapper.UserRoleMapper;
import com.libre.admin.project.system.service.SysUserRoleService;

import java.util.List;

/**
 * @author ZC
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    public List<SysUserRole> getListByUserId(Long userId) {
        return this.list(Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId, userId));
    }
}
