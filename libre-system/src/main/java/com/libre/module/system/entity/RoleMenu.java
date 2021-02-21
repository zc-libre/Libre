package com.libre.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * 角色菜单表
 * @author zhaocheng
 */
@Data
@TableName(value = "sys_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long roleId;


    private Long menuId;


}
