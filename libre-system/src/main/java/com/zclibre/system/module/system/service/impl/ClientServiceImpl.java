package com.zclibre.system.module.system.service.impl;

import com.zclibre.system.module.system.pojo.entity.Client;
import com.zclibre.system.module.system.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zclibre.system.module.system.service.ClientService;
/**
 * @author zhao.cheng
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService{

}
