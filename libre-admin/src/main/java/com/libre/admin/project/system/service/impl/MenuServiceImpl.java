package com.libre.admin.project.system.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.admin.project.system.mapper.MenuMapper;
import com.libre.admin.project.system.entity.Menu;
import com.libre.admin.project.system.service.MenuService;
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{

}
