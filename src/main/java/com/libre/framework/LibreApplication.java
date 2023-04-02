package com.libre.framework;

import com.libre.security.annotation.EnableResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhao.cheng
 */
@EnableResourceServer
@MapperScan("com.libre.**.mapper")
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class LibreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreApplication.class, args);
	}

}
