package com.libre.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhao.cheng
 * @Date 2021/1/15
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void test() {
       redisTemplate.boundValueOps("a").set("a");
        Object a = redisTemplate.boundValueOps("a").get();
        System.out.println(a);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    void test1() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
        System.out.println(passwordEncoder.matches("123456", "{bcrypt}$2a$10$ROsKXZouAPMSMwK5HpR4AOyuLPqh0ZXe/fZJHgQOrOgp4N08Crha2"));
    }
}
