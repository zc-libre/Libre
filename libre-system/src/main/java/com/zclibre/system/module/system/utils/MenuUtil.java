package com.zclibre.system.module.system.utils;

import com.google.common.collect.Lists;
import com.zclibre.system.module.system.vo.MenuMetaVO;
import com.zclibre.system.module.system.vo.MenuVO;
import com.zclibre.system.module.system.entity.SysMenu;
import com.libre.toolkit.core.StringPool;
import com.libre.toolkit.core.StringUtil;

import java.util.List;
import java.util.Objects;

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
			Long parentId = menu.getParentId();
			if (parentId == null && !path.startsWith("http")) {
				menuVO.setPath(StringPool.SLASH + path);
			}
			else {
				menuVO.setPath(path);
			}
			menuVO.setHidden(menu.getHidden());
			if (!menu.getIsFrame()) {
				if (Objects.isNull(parentId)) {
					menuVO.setComponent(StringUtil.isBlank(component) ? "Layout" : component);
				}
				else if (StringUtil.isNotBlank(component)) {
					menuVO.setComponent(component);
				}
			}
			menuVO.setMeta(new MenuMetaVO(title, menu.getIcon(), !menu.getCache()));
			menuVOList.add(menuVO);
		}
		return menuVOList;
	}

}
