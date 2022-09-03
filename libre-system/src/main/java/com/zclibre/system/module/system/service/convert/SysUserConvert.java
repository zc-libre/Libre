package com.zclibre.system.module.system.service.convert;

import com.libre.toolkit.mapstruct.BaseMapping;
import com.zclibre.system.module.system.pojo.entity.SysUser;
import com.zclibre.system.module.system.pojo.vo.UserVO;
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
