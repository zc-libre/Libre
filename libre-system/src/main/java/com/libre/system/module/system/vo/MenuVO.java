package com.libre.system.module.system.vo;

import lombok.Data;

import java.io.Serializable;

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
	private Boolean hidden;
	private String redirect;
	private String component;
	private Boolean alwaysShow;
	private MenuMetaVO meta;

}
