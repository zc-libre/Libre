package com.libre;

import com.libre.common.ratelimiter.EnableRateLimiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zhao.cheng
 * @Date 2021/1/15
 */
@EnableAsync
@EnableRateLimiter
@SpringBootApplication
public class LibreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibreApplication.class, args);
    }

}
