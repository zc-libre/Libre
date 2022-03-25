package com.libre.admin.module.system.param;

import com.libre.admin.common.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * @author ZC
 * @date 2022/1/1 18:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class UserParam extends BaseParam {

    private Boolean enabled;

    private Long deptId;

    private Set<Long> deptIds;

}
