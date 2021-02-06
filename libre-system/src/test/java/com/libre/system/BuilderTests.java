package com.libre.system;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.libre.common.serializer.StringRedisSerializer;
import com.libre.common.tookit.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;

/**
 * @author zhao.cheng
 * @date 2021/2/6 14:01
 */
@DisplayName("builder test")
public class BuilderTests {

    @Test
    void test() {
        Log log = Builder.of(Log::new)
                .with(Log::setId, 1L)
                .with(Log::setUsername, "zhaocheng")
                .with(Log::setCreateTime, LocalDateTime.now())
                .build();
        System.out.println(log);
        Assertions.assertNotNull(log);
    }
}
