package com.libre.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

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
}
