package com.libre.system.module.system.service.convert;

import com.libre.toolkit.mapstruct.BaseMapping;
import com.libre.system.module.system.entity.SysUser;
import com.libre.system.module.system.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Libre
 * @date 2022/1/1 18:34
 */
@Mapper
public interface SysUserConvert extends BaseMapping<SysUser, UserVO> {

     SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);
}
