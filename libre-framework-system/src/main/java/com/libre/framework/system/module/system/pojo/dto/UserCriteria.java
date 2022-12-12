package com.libre.framework.system.module.system.pojo.dto;

import com.libre.framework.common.base.BaseCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * @author Libre
 * @date 2022/1/1 18:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class UserCriteria extends BaseCriteria {

    private Boolean enabled;

    private Long deptId;

    private Set<Long> deptIds;

}
