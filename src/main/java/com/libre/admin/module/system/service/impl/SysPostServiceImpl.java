package com.libre.admin.module.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.module.system.entity.SysPost;
import com.libre.admin.module.system.entity.SysUserPost;
import com.libre.admin.module.system.mapper.SysPostMapper;
import com.libre.admin.module.system.service.SysPostService;
import com.libre.admin.module.system.service.SysUserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhao.cheng
 */
@Service
@RequiredArgsConstructor
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {

    private final SysUserPostService userPostService;

    @Override
    public List<SysPost> getListByUserId(Long userId) {
        List<SysUserPost> userPostList = userPostService.getListByUserId(userId);
        if (CollUtil.isEmpty(userPostList)) {
            return Collections.emptyList();
        }
        Set<Long> postIds = userPostList.stream()
                .map(SysUserPost::getPostId)
                .collect(Collectors.toSet());

        return super.listByIds(postIds);
    }
}
