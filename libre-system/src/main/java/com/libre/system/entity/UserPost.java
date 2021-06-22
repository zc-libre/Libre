package com.libre.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户岗位表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "用户岗位表")
@Data
@TableName(value = "sys_user_post")
public class UserPost {
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
