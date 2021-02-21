package com.libre.module.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao.cheng
 * @date 2021/1/20 9:34
 */
@RestController
public class IndexController {


    @GetMapping({"/", "/index"})
    public String test() {
        return "THE SERVICE IS RUNNING!";
    }
}
