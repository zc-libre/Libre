package com.libre.admin.module.system.param;

import com.libre.admin.common.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author ZC
 * @date 2022/2/2 19:16
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeptParam extends BaseParam {

    private Long parentId;

}
