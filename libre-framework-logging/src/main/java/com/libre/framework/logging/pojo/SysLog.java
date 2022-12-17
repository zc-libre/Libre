package com.libre.framework.logging.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.libre.toolkit.time.DatePattern;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志
 * </p>
 */
@Data
@TableName("sys_log")
public class SysLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 登陆名
	 */
	private String username;

	/**
	 * 日志类别
	 */
	private String logType;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * url 请求参数
	 */
	private String params;

	/**
	 * post data
	 */
	private String data;

	/**
	 * 是否成功[0失败,1成功]
	 */
	private Integer success;

	/**
	 * 类-方法
	 */
	private String classMethod;

	/**
	 * 异常信息
	 */
	private String exceptionDetail;

	/**
	 * 请求ip
	 */
	private String requestIp;

	/**
	 * 请求耗时
	 */
	private Long requestTime;

	/**
	 * 系统
	 */
	private String os;

	/**
	 * 浏览器
	 */
	private String browser;

	/**
	 * 请求者地址
	 */
	private String address;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@ApiModelProperty(value = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime gmtCreate;

}
