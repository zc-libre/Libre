package com.libre.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.module.system.entity.Post;
import com.libre.module.system.mapper.PostMapper;
import com.libre.module.system.service.PostService;
import org.springframework.stereotype.Service;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService{

}
