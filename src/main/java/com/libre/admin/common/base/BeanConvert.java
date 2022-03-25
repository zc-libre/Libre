package com.libre.admin.common.base;

import com.libre.boot.exception.ServiceException;
import org.springframework.beans.BeanUtils;

/**
 * @author ZC
 * @date 2022/1/31 23:42
 */
public class BeanConvert {

    public <T> T convert(Class<T> clazz) {
        try {
            T t = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(this, t);
            return t;
        } catch (Exception e) {
            throw new ServiceException("转换对象失败", e);
        }
    }
}
