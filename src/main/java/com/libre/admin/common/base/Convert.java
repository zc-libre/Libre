package com.libre.admin.common.base;


/**
 * @author ZC
 * @date 2022/1/31 23:44
 */
public interface Convert {

    default <T> T convert(Class<T> targetClass) {
          return null;
    }

}
