package com.zclibre.system.module.system.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Libre
 * @date 2022/2/2 15:43
 */
@Data
public class DeptVO implements Serializable {


    private Long id;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 子部门
     */
    private List<DeptVO> children;
}
