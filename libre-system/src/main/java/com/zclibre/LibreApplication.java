package com.zclibre;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhao.cheng
 */
@MapperScan("com.zclibre.**.mapper")
@SpringBootApplication(scanBasePackages = "com.zclibre")
public class LibreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreApplication.class, args);
	}

}
