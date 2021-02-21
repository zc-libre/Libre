package com.libre.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.module.system.service.dto.UserDTO;
import com.libre.module.system.entity.User;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/
public interface UserService extends IService<User>{

    /**
     * 通过用户名查找用户
     * @param username /
     * @return /
     */
    UserDTO findUserByName(String username);

}
