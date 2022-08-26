package com.zclibre.system.module.system.service.convert;

import com.libre.toolkit.mapstruct.BaseMapping;
import com.zclibre.system.module.security.pojo.PostInfo;
import com.zclibre.system.module.system.entity.SysPost;
import org.mapstruct.Mapper;

/**
 * @author Libre
 * @date 2021/7/12 15:42
 */
@Mapper(componentModel = "spring")
public interface SysPostConvert extends BaseMapping<SysPost, PostInfo> {
}
