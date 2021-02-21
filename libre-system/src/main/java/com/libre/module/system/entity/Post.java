package com.libre.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 岗位表
 * @author zhaocheng
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_post")
public class Post extends BaseEntity implements Serializable {

    /**
     * 部门名称
     */
    @TableField(value = "post_name")
    private String postName;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private String sort;

    /**
     * 状态
     */
    @TableField(value = "`status`")
    private Byte status;


    private static final long serialVersionUID = 1L;
}
