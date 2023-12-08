package com.libre.framework.toolkit.moudle.social.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.toolkit.moudle.social.mapper.SocialMapper;
import com.libre.framework.toolkit.moudle.social.pojo.SocialFriend;
import com.libre.framework.toolkit.moudle.social.service.SocialFriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialFriendServiceImpl extends ServiceImpl<SocialMapper, SocialFriend> implements SocialFriendService {

}
