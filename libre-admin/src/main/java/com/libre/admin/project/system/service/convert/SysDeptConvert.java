package com.libre.admin.project.system.service.convert;

import com.libre.admin.framework.security.pojo.DeptInfo;
import com.libre.admin.project.system.entity.SysDept;
import com.libre.core.mapstruct.BaseConvert;
import org.mapstruct.Mapper;

/**
 * @author ZC
 * @date 2021/7/12 15:39
 */
@Mapper(componentModel = "spring")
public interface SysDeptConvert extends BaseConvert<SysDept, DeptInfo> {
}
