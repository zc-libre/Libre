package com.libre.admin.project.system.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.entity.UserRole;
import com.libre.admin.project.system.mapper.UserRoleMapper;
import com.libre.admin.project.system.service.UserRoleService;
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{

}
