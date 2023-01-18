package com.libre.framework.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.system.mapper.ClientMapper;
import com.libre.framework.system.pojo.entity.Client;
import com.libre.framework.system.service.ClientService;
import org.springframework.stereotype.Service;

/**
 * @author zhao.cheng
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

}
