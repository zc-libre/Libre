package com.libre.admin.framework.utils;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.libre.admin.framework.vo.MenuMetaVO;
import com.libre.admin.framework.vo.MenuVO;
import com.libre.admin.project.system.entity.SysMenu;
import com.libre.core.toolkit.StringPool;

import java.util.List;
import java.util.Objects;

/**
 * 菜单处理过滤
 * @author ZC
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
            menuVO.setName(StrUtil.isNotBlank(name) ? name : title);
            Long parentId = menu.getParentId();
            if (parentId == null && !path.startsWith("http")) {
                menuVO.setPath(StringPool.SLASH + path);
            } else {
                menuVO.setPath(path);
            }
            menuVO.setHidden(menu.getHidden());
            if (!menu.getIsFrame()) {
                if (Objects.isNull(parentId)) {
                    menuVO.setComponent(StrUtil.isBlank(component) ? "Layout" : component);
                } else if (StrUtil.isNotBlank(component)) {
                    menuVO.setComponent(component);
                }
            }
            menuVO.setMeta(new MenuMetaVO(title, menu.getIcon(), !menu.getCache()));
            menuVOList.add(menuVO);
        }
        return menuVOList;
    }
}
