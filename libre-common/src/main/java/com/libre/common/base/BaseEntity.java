package com.libre.common.base;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhao.cheng
 * @Date 2021/1/21
 */
@Data
public class BaseEntity {

    @TableId
    private Long id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long createUser;

    @TableField(fill = FieldFill.UPDATE)
    private Long updateUser;

    @JsonFormat(pattern = DatePattern.HTTP_DATETIME_PATTERN)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    @JsonFormat(pattern = DatePattern.HTTP_DATETIME_PATTERN)
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;
}
