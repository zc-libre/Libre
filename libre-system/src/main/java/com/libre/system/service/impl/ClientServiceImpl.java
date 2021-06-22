package com.libre.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.system.mapper.ClientMapper;
import com.libre.system.entity.Client;
import com.libre.system.service.ClientService;
/**
 * @author zhao.cheng
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService{

}
