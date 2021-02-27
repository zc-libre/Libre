package com.libre;


import cn.hutool.extra.spring.SpringUtil;
import com.libre.common.ratelimiter.EnableRateLimiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zhao.cheng
 * @date 2021/1/15
 */
@EnableAsync
@EnableRateLimiter
@Import(SpringUtil.class)
@SpringBootApplication
public class LibreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibreApplication.class, args);
    }

}
