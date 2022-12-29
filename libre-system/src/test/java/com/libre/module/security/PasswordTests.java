package com.libre.module.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Libre
 * @Date: 2022/8/26 10:25 PM
 */
@SpringBootTest
public class PasswordTests {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void encode() {
		String encode = passwordEncoder.encode("123456");
		System.out.println(encode);
	}

}
