package com.libre.framework.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.libre.framework.common.base.BaseEntity;
import com.libre.toolkit.time.DatePattern;
import com.libre.toolkit.validation.CreateGroup;
import com.libre.toolkit.validation.UpdateGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@TableName("blog_tag")
public class Tag {

	/**
	 * 主键id
	 */
	@TableId
	@Schema(description = "主键id")
	@Null(groups = CreateGroup.class)
	@NotNull(groups = UpdateGroup.class)
	private Long id;

	private String tagName;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@Schema(description = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime gmtCreate;

	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@Schema(description = "更新时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime gmtModified;

	/**
	 * 创建人
	 */
	@Schema(description = "创建人")
	@TableField(fill = FieldFill.INSERT)
	private String gmtCreateName;

	/**
	 * 更新人
	 */
	@Schema(description = "更新人")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String gmtModifiedName;

}
