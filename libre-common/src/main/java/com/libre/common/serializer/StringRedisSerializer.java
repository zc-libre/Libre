package com.libre.common.serializer;

import cn.hutool.core.util.StrUtil;
import com.libre.common.tookit.JsonUtil;
import lombok.SneakyThrows;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 * 重写序列化器
 *
 * @author /
 */
public class StringRedisSerializer implements RedisSerializer<Object> {

    private final Charset charset;

    public StringRedisSerializer() {
        this(StandardCharsets.UTF_8);
    }

    private StringRedisSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }

    @Override
    public String deserialize(@Nullable byte[] bytes) {
        return (bytes == null ? null : new String(bytes, charset));
    }

    @SneakyThrows
    @Override
    public byte[] serialize(@Nullable Object object) {

        String string = JsonUtil.toJson(object);
        if (StrUtil.isBlank(string)) {
            return null;
        }
        string = string.replace("\"", "");
        return string.getBytes(charset);
    }
}
