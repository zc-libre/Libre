package com.libre.framework.module.security;

import com.libre.framework.system.pojo.entity.SysMenu;
import com.libre.framework.system.service.SysMenuService;
import com.libre.framework.system.service.SysRoleMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Libre
 * @Date: 2022/8/26 10:25 PM
 */
@SpringBootTest
public class PasswordTests {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SysRoleMenuService roleMenuService;

	@Autowired
	SysMenuService menuService;

	@Test
	void encode() {
		String encode = passwordEncoder.encode("123456");
		System.out.println(encode);
	}

	@Test
	void insert() {
		List<SysMenu> sysMenus = menuService.list();
		List<SysMenu> menus = sysMenus.stream().map(menu -> {
			menu.setStatus(1);
			return menu;
		}).collect(Collectors.toList());
		menuService.saveOrUpdateBatch(menus);

	}

}
