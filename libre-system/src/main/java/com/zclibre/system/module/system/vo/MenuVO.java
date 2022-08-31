package com.zclibre.system.module.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 前端菜单路由
 *
 * @author L.cm
 */
@Data
public class MenuVO implements Serializable {

	private Long id;

	private Long parentId;

	private String name;

	private String path;

	private Integer hidden;

	private String redirect;

	private String component;

	private Integer alwaysShow;

	private MenuMetaVO meta;

	private List<MenuVO> children;

}
