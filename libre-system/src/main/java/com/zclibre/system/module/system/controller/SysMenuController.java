package com.zclibre.system.module.system.controller;

import com.libre.toolkit.result.R;
import com.zclibre.system.module.system.pojo.entity.SysMenu;
import com.zclibre.system.module.system.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Libre
 * @Date: 2022/9/11 4:23 PM
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/menu")
public class SysMenuController {

	private final SysMenuService menuService;

	@GetMapping("all")
	public R<List<SysMenu>> query() {
		List<SysMenu> list = menuService.list();
		return R.data(list);
	}

}
