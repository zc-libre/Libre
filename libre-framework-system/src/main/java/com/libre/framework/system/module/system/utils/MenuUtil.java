package com.libre.framework.system.module.system.utils;

import com.google.common.collect.Lists;
import com.libre.framework.system.module.system.constant.MenuConstants;
import com.libre.framework.system.module.system.pojo.entity.SysMenu;
import com.libre.framework.system.module.system.pojo.vo.MenuMetaVO;
import com.libre.framework.system.module.system.pojo.vo.MenuVO;
import com.libre.toolkit.core.StringPool;
import com.libre.toolkit.core.StringUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 菜单处理过滤
 *
 * @author Libre
 * @date 2021/7/12 19:28
 */
public class MenuUtil {

	public static List<MenuVO> transform(List<SysMenu> menuList) {
		List<MenuVO> menuVOList = Lists.newArrayList();
		for (SysMenu menu : menuList) {
			String name = menu.getName();
			String path = menu.getPath();
			String title = menu.getTitle();
			String component = menu.getComponent();
			MenuVO menuVO = new MenuVO();
			menuVO.setId(menu.getId());
			menuVO.setParentId(menu.getParentId());
			menuVO.setName(StringUtil.isNotBlank(name) ? name : title);
			menuVO.setType(menu.getType());
			Long parentId = menu.getParentId();
			if (parentId == null && StringUtil.isNotBlank(path) && !path.startsWith("http")) {
				menuVO.setPath(StringPool.SLASH + path);
			}
			else {
				menuVO.setPath(path);
			}
			menuVO.setHidden(menu.getHidden());
			if (Objects.equals(MenuConstants.IS_FRAME_NO, menu.getIsFrame())) {
				if (Objects.isNull(parentId)) {
					menuVO.setComponent(StringUtil.isBlank(component) ? "Layout" : component);
				}
				else if (StringUtil.isNotBlank(component)) {
					menuVO.setComponent(component);
				}
			}

			menuVO.setMeta(new MenuMetaVO(title, menu.getIcon(), menu.getCache()));
			menuVO.setIsFrame(menu.getIsFrame());
			menuVO.setSeq(menu.getSeq());
			menuVO.setCache(menu.getCache());
			menuVOList.add(menuVO);
		}

		return menuVOList.stream().filter(menuVO -> menuVO.getParentId() == 0)
				.peek(menuVO -> {
					List<MenuVO> children = getChildren(menuVO, menuVOList);
					if (CollectionUtils.isNotEmpty(children)) {
						menuVO.setChildren(children);
					}
				}).collect(Collectors.toList());
	}

	private static List<MenuVO> getChildren(MenuVO menuVO, List<MenuVO> menus) {
		return menus.stream().filter(item -> Objects.equals(item.getParentId(), menuVO.getId()))
				.peek(menu -> menu.setChildren(getChildren(menu, menus))).collect(Collectors.toList());
	}

}
