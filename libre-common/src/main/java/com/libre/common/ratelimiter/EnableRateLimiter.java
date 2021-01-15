package com.libre.common.ratelimiter;

import com.libre.common.config.RateLimiterConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhao.cheng
 * @Date 2021/1/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RateLimiterConfiguration.class)
public @interface EnableRateLimiter {
}
