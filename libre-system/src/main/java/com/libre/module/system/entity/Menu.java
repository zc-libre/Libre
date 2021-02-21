package com.libre.module.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.common.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;



/**
 * 菜单表
 * @author zhaocheng
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
public class Menu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


}
