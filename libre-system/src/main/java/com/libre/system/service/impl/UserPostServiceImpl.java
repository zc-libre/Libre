package com.libre.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.system.entity.UserPost;
import com.libre.system.mapper.UserPostMapper;
import com.libre.system.service.UserPostService;
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService{

}
