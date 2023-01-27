package com.libre.framework.tookit.moudle.file.pojo;

import com.libre.framework.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author: Libre
 * @Date: 2023/1/18 12:05 AM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SysFile extends BaseEntity {

	private Long id;

	@ApiModelProperty(value = "真实文件名")
	private String realName;

	@ApiModelProperty(value = "文件名")
	private String name;

	@ApiModelProperty(value = "后缀")
	private String suffix;

	@ApiModelProperty(value = "路径")
	private String path;

	@ApiModelProperty(value = "存储类型")
	private Integer saveType;

	@ApiModelProperty(value = "大小")
	private Long size;

}
