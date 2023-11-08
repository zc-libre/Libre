package com.libre.framework.social.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.social.mapper.SocialMapper;
import com.libre.framework.social.pojo.SocialFriend;
import com.libre.framework.social.service.SocialFriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialFriendServiceImpl extends ServiceImpl<SocialMapper, SocialFriend> implements SocialFriendService {

}
