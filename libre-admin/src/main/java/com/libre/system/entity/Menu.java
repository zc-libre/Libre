package com.libre.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.system.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单表
 * @author zhao.cheng
 */
@ApiModel(value = "菜单表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
public class Menu extends BaseEntity {

}
