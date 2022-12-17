package com.libre.framework.logging.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.logging.mapper.SysLogMapper;
import com.libre.framework.logging.pojo.SysLog;
import com.libre.framework.logging.service.SysLogService;
import org.springframework.stereotype.Component;

/**
 * @author: Libre
 * @Date: 2022/12/17 6:04 PM
 */
@Component
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
}
