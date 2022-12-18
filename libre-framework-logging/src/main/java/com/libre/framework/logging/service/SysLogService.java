package com.libre.framework.logging.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.logging.pojo.SysLog;
import com.libre.framework.logging.pojo.SysLogCriteria;

/**
 * @author: Libre
 * @Date: 2022/12/17 6:03 PM
 */
public interface SysLogService extends IService<SysLog> {


    PageDTO<SysLog> findPage(PageDTO<SysLog> page, SysLogCriteria criteria);
}
