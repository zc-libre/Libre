package com.libre.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "角色表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
public class Role extends BaseEntity {

    /**
     * 角色名
     */
    @ApiModelProperty(value = "角色名")
    private String roleName;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;

}
