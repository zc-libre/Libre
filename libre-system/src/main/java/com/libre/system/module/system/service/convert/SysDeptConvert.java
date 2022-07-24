package com.libre.system.module.system.service.convert;

import com.libre.toolkit.mapstruct.BaseMapping;
import com.libre.system.module.security.pojo.DeptInfo;
import com.libre.system.module.system.entity.SysDept;

import org.mapstruct.Mapper;

/**
 * @author Libre
 * @date 2021/7/12 15:39
 */
@Mapper(componentModel = "spring")
public interface SysDeptConvert extends BaseMapping<SysDept, DeptInfo> {
}
