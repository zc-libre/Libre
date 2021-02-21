package com.libre.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;



/**
 * 角色部门表
 * @author zhaocheng
 */
@Data
@TableName(value = "sys_role_dept")
public class RoleDept implements Serializable {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 部门id
     */
    private Long deptId;

    private static final long serialVersionUID = 1L;
}
