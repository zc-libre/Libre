package com.libre.admin.module.system.service.convert;

import com.libre.admin.module.security.pojo.RoleInfo;
import com.libre.admin.module.system.entity.SysRole;
import com.libre.core.mapstruct.BaseConvert;
import org.mapstruct.Mapper;

/**
 * @author ZC
 * @date 2021/7/12 14:48
 */
@Mapper(componentModel = "spring")
public interface SysRoleConvert extends BaseConvert<SysRole, RoleInfo> {
}
