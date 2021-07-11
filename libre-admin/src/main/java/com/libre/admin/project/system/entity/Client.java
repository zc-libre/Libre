package com.libre.admin.project.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 客户端表
 *
 * @author zhao.cheng
 */
@ApiModel(value = "客户端表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_client")
public class Client extends BaseEntity {
    /**
     * 客户端id
     */
    @ApiModelProperty(value = "客户端id")
    private String clientId;

    /**
     * 客户端密钥
     */
    @ApiModelProperty(value = "客户端密钥")
    private String clientSecret;

    /**
     * 资源集合
     */
    @ApiModelProperty(value = "资源集合")
    private String resourceIds;

    /**
     * 授权范围
     */
    @ApiModelProperty(value = "授权范围")
    private String scope;

    /**
     * 授权类型
     */
    @ApiModelProperty(value = "授权类型")
    private String authorizedGrantTypes;

    /**
     * 回调地址
     */
    @ApiModelProperty(value = "回调地址")
    private String webServerRedirectUri;

    /**
     * 权限
     */
    @ApiModelProperty(value = "权限")
    private String authorities;

    /**
     * 令牌过期秒数
     */
    @ApiModelProperty(value = "令牌过期秒数")
    private Integer accessTokenValidity;

    /**
     * 刷新令牌过期秒数
     */
    @ApiModelProperty(value = "刷新令牌过期秒数")
    private Integer refreshTokenValidity;

    /**
     * 附加说明
     */
    @ApiModelProperty(value = "附加说明")
    private String additionalInformation;

    /**
     * 自动授权
     */
    @ApiModelProperty(value = "自动授权")
    private String autoapprove;


    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

}
