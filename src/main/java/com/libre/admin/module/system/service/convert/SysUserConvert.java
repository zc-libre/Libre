package com.libre.admin.module.system.service.convert;

import com.libre.admin.module.system.entity.SysUser;
import com.libre.admin.module.system.vo.UserVO;
import com.libre.core.mapstruct.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author ZC
 * @date 2022/1/1 18:34
 */
@Mapper
public interface SysUserConvert extends BaseConvert<SysUser, UserVO> {

     SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);
}
