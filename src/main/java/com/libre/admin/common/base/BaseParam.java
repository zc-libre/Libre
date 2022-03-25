package com.libre.admin.common.base;

import com.libre.core.toolkit.CollectionUtil;
import com.libre.core.toolkit.StringUtil;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ZC
 * @date 2022/1/1 18:20
 */
@Data
public abstract class BaseParam {

    private Long id;
    /**
     * 模糊搜索字段
     */
    private String blurry;

    /**
     * 创建时间
     */
    private List<LocalDateTime> createTime;


    public boolean isBlurryQuery() {
        return StringUtil.isNoneBlank(blurry);
    }

    public boolean haveTime() {
        return CollectionUtil.isNotEmpty(this.createTime) && this.createTime.size() == 2;
    }

    public LocalDateTime getStartTime() {
        return this.createTime.get(0);
    }

    public LocalDateTime getEndTime() {
        return this.createTime.get(1);
    }
}
