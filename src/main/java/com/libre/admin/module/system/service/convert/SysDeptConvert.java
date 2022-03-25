package com.libre.admin.module.system.service.convert;

import com.libre.admin.module.security.pojo.DeptInfo;
import com.libre.admin.module.system.entity.SysDept;
import com.libre.core.mapstruct.BaseConvert;
import org.mapstruct.Mapper;

/**
 * @author ZC
 * @date 2021/7/12 15:39
 */
@Mapper(componentModel = "spring")
public interface SysDeptConvert extends BaseConvert<SysDept, DeptInfo> {
}
