package com.libre.admin.module.system.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.module.system.mapper.ClientMapper;
import com.libre.admin.module.system.entity.Client;
import com.libre.admin.module.system.service.ClientService;
/**
 * @author zhao.cheng
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService{

}
