package com.libre.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author zhao.cheng
 */
@MapperScan("com.libre.**.mapper")
@SpringBootApplication
public class LibreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreApplication.class, args);
	}

}
