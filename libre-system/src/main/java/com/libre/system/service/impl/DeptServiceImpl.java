package com.libre.system.service.impl;

import com.libre.system.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.system.entity.Dept;
import com.libre.system.mapper.DeptMapper;
import com.libre.system.service.DeptService;
/**
 * @author zhao.cheng
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService{


}
