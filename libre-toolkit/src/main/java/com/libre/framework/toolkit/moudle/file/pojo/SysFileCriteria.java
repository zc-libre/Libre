package com.libre.framework.toolkit.moudle.file.pojo;

import com.libre.framework.common.base.BaseCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author: Libre
 * @Date: 2023/1/27 3:56 AM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SysFileCriteria extends BaseCriteria {

	private Integer saveType;

}
