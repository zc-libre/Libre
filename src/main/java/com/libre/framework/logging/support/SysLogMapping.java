package com.libre.framework.logging.support;

import com.libre.boot.exception.LibreErrorEvent;
import com.libre.framework.logging.pojo.SysLog;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author: Libre
 * @Date: 2022/12/17 6:05 PM
 */
@Mapper
public interface SysLogMapping extends BaseMapping<SysLogEvent, SysLog> {

	SysLogMapping INSTANCE = Mappers.getMapper(SysLogMapping.class);

	SysLog convertToSysLog(LibreErrorEvent event);

}
