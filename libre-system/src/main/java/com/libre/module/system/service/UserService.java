package com.libre.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.common.security.model.SecurityUser;
import com.libre.module.security.vo.UserVO;
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
    SecurityUser findUserByName(String username);

    /**
     * 获取用户详情
     * @return /
     */
    UserVO getUserInfo(Long id);

}
