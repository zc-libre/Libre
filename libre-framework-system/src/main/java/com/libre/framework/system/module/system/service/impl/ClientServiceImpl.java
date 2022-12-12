package com.libre.framework.system.module.system.service.impl;

import com.libre.framework.system.module.system.service.ClientService;
import com.libre.framework.system.module.system.pojo.entity.Client;
import com.libre.framework.system.module.system.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author zhao.cheng
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

}
