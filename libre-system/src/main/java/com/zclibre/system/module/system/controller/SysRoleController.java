package com.zclibre.system.module.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.toolkit.result.R;
import com.zclibre.system.module.system.pojo.dto.RoleCriteria;
import com.zclibre.system.module.system.pojo.dto.RoleDTO;
import com.zclibre.system.module.system.pojo.dto.RoleMenuDTO;
import com.zclibre.system.module.system.pojo.entity.SysMenu;
import com.zclibre.system.module.system.pojo.entity.SysRole;
import com.zclibre.system.module.system.pojo.entity.SysRoleMenu;
import com.zclibre.system.module.system.pojo.vo.RoleVO;
import com.zclibre.system.module.system.service.SysMenuService;
import com.zclibre.system.module.system.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author: Libre
 * @Date: 2022/9/4 5:05 PM
 */
@RestController
@RequestMapping("/sys/role")
@RequiredArgsConstructor
public class SysRoleController {

	private final SysRoleService roleService;

	private final SysMenuService menuService;


	@ApiOperation("角色列表")
	@PostMapping("/list")
	public R<PageDTO<RoleVO>> list(Page<SysRole> page, RoleCriteria roleCriteria) {
		PageDTO<RoleVO> rolePage = roleService.findByPage(page, roleCriteria);
		return R.data(rolePage);
	}

	@Operation(summary = "获取单个role")
	@GetMapping("{id}")
	public R<SysRole> query(@PathVariable Long id) {
		return R.data(roleService.getById(id));
	}


	@Operation(summary = "获取角色菜单")
	@GetMapping("{id}/menus")
	public R<List<SysMenu>> getMenus(@NotNull @PathVariable("id") Long id) {
		return R.data(menuService.getListByRoleIds(Collections.singletonList(id)));
	}

	@Operation(summary = "修改角色菜单")
	@PostMapping("/edit_menu")
	public R<Boolean> updateMenu(@Validated @RequestBody RoleMenuDTO roleMenu) {
		SysRole role = roleService.getById(roleMenu.getId());
		boolean res = roleService.updateMenus(role, roleMenu.getMenuIds());
		return R.status(res);
	}

	@PostMapping("/edit")
	public R<Boolean> edit(RoleDTO roleDTO) {
		boolean res = roleService.edit(roleDTO);
		return R.status(res);
	}


	@Operation(summary = "删除角色")
	@DeleteMapping
	public R<Boolean> delete(@NotEmpty @RequestBody Set<Long> ids) {
		boolean res = roleService.deleteIfUnusedByIds(ids);
		return R.status(res);
	}

}
