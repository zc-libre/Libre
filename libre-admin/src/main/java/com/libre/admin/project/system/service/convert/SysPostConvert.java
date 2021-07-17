package com.libre.admin.project.system.service.convert;

import com.libre.admin.framework.security.pojo.PostInfo;
import com.libre.admin.project.system.entity.SysPost;
import com.libre.core.mapstruct.BaseConvert;
import org.mapstruct.Mapper;

/**
 * @author ZC
 * @date 2021/7/12 15:42
 */
@Mapper(componentModel = "spring")
public interface SysPostConvert extends BaseConvert<SysPost, PostInfo> {
}
