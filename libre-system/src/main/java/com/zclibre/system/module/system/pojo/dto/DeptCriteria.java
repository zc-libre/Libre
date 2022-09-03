package com.zclibre.system.module.system.pojo.dto;

import com.zclibre.common.base.BaseCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Libre
 * @date 2022/2/2 19:16
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeptCriteria extends BaseCriteria {

    private Long parentId;


}
