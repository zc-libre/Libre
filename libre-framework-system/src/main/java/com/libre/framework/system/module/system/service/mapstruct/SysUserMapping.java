package com.libre.framework.system.module.system.service.mapstruct;

import com.libre.framework.system.module.system.pojo.dto.UserDTO;
import com.libre.framework.system.module.system.pojo.entity.SysUser;
import com.libre.toolkit.mapstruct.BaseMapping;
import com.libre.framework.system.module.system.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Libre
 * @date 2022/1/1 18:34
 */
@Mapper
public interface SysUserMapping extends BaseMapping<SysUser, UserVO> {

	SysUserMapping INSTANCE = Mappers.getMapper(SysUserMapping.class);

	SysUser convertToUser(UserDTO userDTO);

}
