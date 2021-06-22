package com.libre.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.system.mapper.PostMapper;
import com.libre.system.entity.Post;
import com.libre.system.service.PostService;
/**
 * @author zhao.cheng
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService{

}
