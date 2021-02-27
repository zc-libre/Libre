package com.libre.module.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.common.security.model.SecurityUser;
import com.libre.module.security.vo.UserVO;
import com.libre.module.system.convert.UserConvert;
import com.libre.module.system.entity.User;
import com.libre.module.system.mapper.UserMapper;
import com.libre.module.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserConvert userConvert;

    @Override
    public SecurityUser findUserByName(String username) {
        User user = Optional.ofNullable(baseMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username)))
                             .orElseThrow(() -> new UsernameNotFoundException("用户名未找到"));

        return userConvert.toUserDTO(user);
    }

    @Override
    public UserVO getUserInfo(Long id) {

        return null;
    }
}
