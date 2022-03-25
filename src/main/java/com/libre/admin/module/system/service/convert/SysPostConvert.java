package com.libre.admin.module.system.service.convert;

import com.libre.admin.module.security.pojo.PostInfo;
import com.libre.admin.module.system.entity.SysPost;
import com.libre.core.mapstruct.BaseConvert;
import org.mapstruct.Mapper;

/**
 * @author ZC
 * @date 2021/7/12 15:42
 */
@Mapper(componentModel = "spring")
public interface SysPostConvert extends BaseConvert<SysPost, PostInfo> {
}
