package com.zclibre.system.module.system.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: Libre
 * @Date: 2022/9/11 3:29 PM
 */
@Data
public class RoleMenuDTO {

    /**
     * 角色id
     */
    @NotNull
    private Long id;
    /**
     * 菜单id列表
     */
    @NotEmpty
    private List<Long> menuIds;
}
