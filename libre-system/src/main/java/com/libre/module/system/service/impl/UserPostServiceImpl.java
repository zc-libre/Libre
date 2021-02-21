package com.libre.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.module.system.entity.UserPost;
import com.libre.module.system.mapper.UserPostMapper;
import com.libre.module.system.service.UserPostService;
import org.springframework.stereotype.Service;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService{

}
