package com.libre.framework.module.security;

import com.google.common.collect.Lists;
import com.libre.framework.system.module.system.constant.MenuConstants;
import com.libre.framework.system.module.system.mapper.RoleMenuMapper;
import com.libre.framework.system.module.system.mapper.SysMenuMapper;
import com.libre.framework.system.module.system.pojo.entity.SysMenu;
import com.libre.framework.system.module.system.pojo.entity.SysRoleMenu;
import com.libre.framework.system.module.system.service.SysMenuService;
import com.libre.framework.system.module.system.service.SysRoleMenuService;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
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
