package com.libre.module.security.service;

import com.libre.common.security.model.JwtUser;
import com.libre.common.security.model.SecurityUser;
import com.libre.module.system.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.libre.module.security.constant.SecurityConstants.ENCODING_ID;

/**
 * @author zhao.cheng
 * @date 2021/1/17
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser user = userService.findUserByName(username);
        user.setPassword(ENCODING_ID + user.getPassword());

        return new JwtUser(user);
    }
}
