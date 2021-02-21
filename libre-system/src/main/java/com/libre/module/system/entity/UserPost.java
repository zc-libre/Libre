package com.libre.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
* @author  zhao.cheng
* @Date  2021/2/21
*/

/**
 * 用户岗位表
 * @author zhaocheng
 */
@Data
@TableName(value = "sys_user_post")
public class UserPost implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 岗位id
     */
    private Long postId;


}
