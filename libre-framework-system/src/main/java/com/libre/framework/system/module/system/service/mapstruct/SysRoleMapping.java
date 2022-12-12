package com.libre.framework.system.module.system.service.mapstruct;

import com.libre.framework.system.module.security.pojo.RoleInfo;
import com.libre.framework.system.module.system.pojo.dto.RoleDTO;
import com.libre.toolkit.mapstruct.BaseMapping;
import com.libre.framework.system.module.system.pojo.entity.SysRole;
import com.libre.framework.system.module.system.pojo.vo.RoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Libre
 * @date 2021/7/12 14:48
 */
@Mapper
public interface SysRoleMapping extends BaseMapping<SysRole, RoleInfo> {

    SysRoleMapping INSTANCE = Mappers.getMapper(SysRoleMapping.class);

    List<RoleVO> convertToRoleList(List<SysRole> roles);

    SysRole convertToRole(RoleDTO roleDTO);
}
