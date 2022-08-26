package com.zclibre.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
