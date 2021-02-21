package com.libre.module.security.controller;

import com.libre.common.tookit.result.R;
import com.libre.module.security.service.dto.AuthUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao.cheng
 * @Date 2021/2/18
 */
@RestController
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/auth/token")
    public R login(@RequestBody AuthUserDTO authUser) {
        return null;
    }

}
