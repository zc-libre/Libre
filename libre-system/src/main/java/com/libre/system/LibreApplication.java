package com.libre.system;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhao.cheng
 * @date 2021/1/15
 */
@MapperScan("com.libre.system.mapper")
@EnableMethodCache(basePackages = "com.libre")
@EnableCreateCacheAnnotation
@SpringBootApplication
public class LibreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibreApplication.class, args);
    }

}
