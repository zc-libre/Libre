package com.libre.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    void save() {
        redisTemplate.opsForValue().set("a", "胜帮科技股份有限公司");
    }
}
