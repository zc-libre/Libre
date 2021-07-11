package com.libre.admin.project.system.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.entity.UserPost;
import com.libre.admin.project.system.mapper.UserPostMapper;
import com.libre.admin.project.system.service.UserPostService;
/**
 * @author zhao.cheng
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService{

}
