package com.libre.framework.system.module.system.controller;

import com.libre.framework.system.module.security.pojo.RoleInfo;
import com.libre.framework.system.module.security.pojo.dto.AuthUser;
import com.libre.framework.system.module.security.pojo.dto.UserInfo;
import com.libre.framework.system.module.security.utils.SecurityUtil;
import com.libre.framework.system.module.system.pojo.entity.SysRole;
import com.libre.framework.system.module.system.service.SysUserService;
import com.libre.toolkit.result.R;
import com.libre.framework.system.module.system.pojo.entity.SysMenu;
import com.libre.framework.system.module.system.pojo.vo.MenuVO;
import com.libre.framework.system.module.system.service.SysMenuService;
import com.libre.framework.system.module.system.utils.MenuUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	@GetMapping("/role-menus")
	public R<List<SysMenu>> roleMenus(AuthUser user) {
		List<SysMenu> menuList = menuService.getMenuListByUsername(user.getUsername());
		return R.data(menuList);
	}


	@Operation(summary = "查询菜单:根据ID获取同级与上级数据")
	@PostMapping("superior")
	public R<List<SysMenu>> getSuperior(@RequestBody List<Long> ids) {
		List<SysMenu> menuList = menuService.getSuperior(ids);
		return R.data(menuList);
	}

	@GetMapping("tree")
	public R<List<MenuVO>> tree() {
		List<SysMenu> menuList = menuService.list();
		List<MenuVO> vos = MenuUtil.transform(menuList);
		return R.data(vos);
	}

	@PostMapping
	public R<Boolean> saveOrUpdate(SysMenu sysMenu) {
		menuService.saveOrUpdate(sysMenu);
		return R.status(true);
	}


	@DeleteMapping
	public R<Boolean> deleteByIds(@RequestBody List<Long> ids) {
		menuService.deleteByIds(ids);
		return R.status(true);
	}

}
