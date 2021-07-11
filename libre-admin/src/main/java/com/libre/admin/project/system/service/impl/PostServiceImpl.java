package com.libre.admin.project.system.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.mapper.PostMapper;
import com.libre.admin.project.system.entity.Post;
import com.libre.admin.project.system.service.PostService;
/**
 * @author zhao.cheng
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService{

}
