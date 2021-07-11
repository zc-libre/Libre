package com.libre.admin.project.system.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.mapper.ClientMapper;
import com.libre.admin.project.system.entity.Client;
import com.libre.admin.project.system.service.ClientService;
/**
 * @author zhao.cheng
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService{

}
