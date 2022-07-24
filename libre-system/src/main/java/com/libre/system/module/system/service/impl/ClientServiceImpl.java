package com.libre.system.module.system.service.impl;

import com.libre.system.module.system.entity.Client;
import com.libre.system.module.system.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.system.module.system.service.ClientService;
/**
 * @author zhao.cheng
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService{

}
