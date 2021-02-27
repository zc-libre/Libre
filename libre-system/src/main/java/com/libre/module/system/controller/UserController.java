package com.libre.module.system.controller;

import com.libre.common.tookit.result.R;
import com.libre.module.security.vo.UserVO;
import com.libre.module.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao.cheng
 * @Date 2021/2/27
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/info/{id}")
    public R<UserVO> getInfo(@PathVariable("id") Long id) {
        UserVO userInfo = userService.getUserInfo(id);
        return R.data(userInfo);
    }
}
