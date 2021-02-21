package com.libre.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.common.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/

/**
 * 部门表
 * @author zhaocheng
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_dept")
public class Dept extends BaseEntity implements Serializable {


    /**
     * 父id
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String deptName;



    private static final long serialVersionUID = 1L;
}
