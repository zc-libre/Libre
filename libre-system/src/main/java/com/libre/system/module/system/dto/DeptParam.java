package com.libre.system.module.system.dto;

import com.libre.common.base.BaseParam;
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
public class DeptParam extends BaseParam {

    private Long parentId;

}
