package com.libre.admin.project.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.entity.SysUserPost;
import com.libre.admin.project.system.mapper.UserPostMapper;
import com.libre.admin.project.system.service.SysUserPostService;

import java.util.List;

/**
 * @author zhao.cheng
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, SysUserPost> implements SysUserPostService {

    @Override
    public List<SysUserPost> getListByUserId(Long userId) {
        return super.list(Wrappers.<SysUserPost>lambdaQuery()
                .eq(SysUserPost::getUserId, userId));
    }
}
