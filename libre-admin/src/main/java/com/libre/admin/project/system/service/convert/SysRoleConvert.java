package com.libre.admin.project.system.service.convert;

import com.libre.admin.framework.security.pojo.RoleInfo;
import com.libre.admin.project.system.entity.SysRole;
import com.libre.core.mapstruct.BaseConvert;
import org.mapstruct.Mapper;

/**
 * @author ZC
 * @date 2021/7/12 14:48
 */
@Mapper(componentModel = "spring")
public interface SysRoleConvert extends BaseConvert<SysRole, RoleInfo> {
}
