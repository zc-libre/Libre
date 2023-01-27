package com.libre.framework.tookit.moudle.file.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: Libre
 * @Date: 2023/1/27 3:42 AM
 */
@Getter
@AllArgsConstructor
public enum FileSaveType {

    LOCAL(1),

    OSS(2),

    ;

    private final Integer type;
}
