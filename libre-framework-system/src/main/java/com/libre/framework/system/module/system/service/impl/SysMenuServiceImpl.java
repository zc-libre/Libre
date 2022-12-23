package com.libre.framework.system.module.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.libre.framework.system.module.security.pojo.dto.UserInfo;
import com.libre.framework.system.module.system.constant.UserConstants;
import com.libre.framework.system.module.system.mapper.SysMenuMapper;
import com.libre.framework.system.module.system.pojo.entity.SysRole;
import com.libre.framework.system.module.system.service.SysRoleMenuService;
import com.libre.framework.system.module.system.service.SysUserService;
import com.libre.framework.system.module.system.utils.MenuUtil;
import com.libre.toolkit.exception.LibreException;
import com.libre.framework.common.constant.LibreConstants;
import com.libre.framework.system.module.system.constant.MenuConstants;
import com.libre.framework.system.module.system.pojo.entity.SysMenu;
import com.libre.framework.system.module.system.pojo.entity.SysRoleMenu;
import com.libre.framework.system.module.system.service.SysMenuService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Libre
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

	private final SysRoleMenuService roleMenuService;

	private final SysUserService sysUserService;

	@Override
	public List<SysMenu> getListByRoleIds(Collection<Long> roleIds) {
		List<Long> roleMenuIdList = roleMenuService.getIdListByRoleIds(roleIds);
		if (CollectionUtils.isEmpty(roleMenuIdList)) {
			return Collections.emptyList();
		}
		return super.listByIds(roleMenuIdList);
	}

	@Override
	public List<SysMenu> getAllMenu() {
		getQueryWrapper();
		return super.list(getQueryWrapper());
	}

	@Override
	public List<SysMenu> getNavByRoleIds(Collection<Long> roleIds) {
		List<Long> roleMenuIdList = roleMenuService.getIdListByRoleIds(roleIds);
		if (CollectionUtils.isEmpty(roleMenuIdList)) {
			return Collections.emptyList();
		}
		LambdaQueryWrapper<SysMenu> queryWrapper = getQueryWrapper();
		return super.list(queryWrapper.in(SysMenu::getId, roleMenuIdList));
	}

	@Override
	public boolean saveOrUpdate(SysMenu entity) {
		return super.saveOrUpdate(entity);
	}

	@Override
	public boolean add(SysMenu menu) {
		return this.save(menu);
	}

	@Override
	public List<SysMenu> getSuperior(List<Long> ids) {
		List<SysMenu> menuList = this.getAllMenu();
		if (CollectionUtils.isEmpty(ids)) {
			return menuList;
		}
		List<Long> path = Lists.newArrayList();
		for (Long id : ids) {
			findPath(id, path);
		}
		if (CollectionUtils.isEmpty(path)) {
			return menuList;
		}
		return menuList.stream().filter(menu -> path.contains(menu.getId()) && !ids.contains(menu.getId()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean deleteByIds(List<Long> ids) {
		List<SysRoleMenu> roleMenuList = roleMenuService.getListByMenuIds(ids);
		if (roleMenuList != null && !roleMenuList.isEmpty()) {
			throw new LibreException("存在角色关联关系");
		}
		return super.removeByIds(ids);
	}

	@Override
	public List<SysMenu> getMenuListByUsername(String username) {
		UserInfo userInfo = sysUserService.findUserInfoByUsername(username);
		if (Objects.equals(UserConstants.IS_ADMIN_YES, userInfo.getIsAdmin())) {
			return this.getAllMenu();
		}
		List<SysRole> roleList = userInfo.getRoles();
		if (CollectionUtils.isEmpty(roleList)) {
			return Collections.emptyList();
		}

		Set<Long> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toSet());
		return this.getNavByRoleIds(roleIds);
	}

	/**
	 * 菜单类型（0目录 1菜单 2按钮）
	 * @return /
	 */
	private static LambdaQueryWrapper<SysMenu> getQueryWrapper() {
		return Wrappers.<SysMenu>lambdaQuery().in(SysMenu::getType, 0, 1)
				.eq(SysMenu::getHidden, MenuConstants.IS_HIDDEN_NO).eq(SysMenu::getStatus, LibreConstants.STATUS_ON)
				.orderByAsc(SysMenu::getSeq);
	}

	private void findPath(Long parentId, List<Long> path) {
		if (Objects.isNull(parentId) || parentId == 0) {
			path.add(parentId);
			return;
		}
		path.add(parentId);
		SysMenu menu = getById(parentId);
		if (Objects.isNull(menu)) {
			return;
		}
		findPath(menu.getParentId(), path);
	}

	private List<SysMenu> getByParentId(List<SysMenu> menuList, Long parentId) {
		return menuList.stream().filter(menu -> Objects.equals(menu.getParentId(), parentId))
				.collect(Collectors.toList());
	}

}
