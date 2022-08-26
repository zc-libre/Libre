package com.zclibre.system.module.system.service.convert;

import com.libre.toolkit.mapstruct.BaseMapping;
import com.zclibre.system.module.security.pojo.RoleInfo;
import com.zclibre.system.module.system.entity.SysRole;
import org.mapstruct.Mapper;

/**
 * @author Libre
 * @date 2021/7/12 14:48
 */
@Mapper(componentModel = "spring")
public interface SysRoleConvert extends BaseMapping<SysRole, RoleInfo> {
}
