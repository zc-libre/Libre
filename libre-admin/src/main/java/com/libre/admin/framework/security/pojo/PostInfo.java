package com.libre.admin.framework.security.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 岗位信息
 * @author ZC
 */
@Data
public class PostInfo implements Serializable {
	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 岗位编码
	 */
	private String code;
	/**
	 * 岗位名称
	 */
	private String name;
}
