package com.libre.framework.system.module.system.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 用户岗位表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "用户岗位表")
@Data
@TableName(value = "sys_user_post")
public class SysUserPost {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 岗位id
     */
    @ApiModelProperty(value = "岗位id")
    private Long postId;
}
