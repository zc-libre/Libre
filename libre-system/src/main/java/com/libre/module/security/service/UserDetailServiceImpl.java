package com.libre.module.security.service;

import com.libre.module.security.service.dto.JwtUserDTO;
import com.libre.module.system.service.dto.UserDTO;
import com.libre.module.system.service.RoleService;
import com.libre.module.system.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhao.cheng
 * @date 2021/1/17
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final RoleService roleService;

    public UserDetailServiceImpl(UserService userService,
                                 RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = userService.findUserByName(username);

        return new JwtUserDTO(user);
    }
}
