package com.libre.system.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.system.mapper.RoleMapper;
import com.libre.system.entity.Role;
import com.libre.system.service.RoleService;
/**
 * @author zhao.cheng
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}