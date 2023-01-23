package com.libre.framework.tookit.moudle.openapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: Libre
 * @Date: 2023/1/23 4:01 AM
 */
@Getter
@AllArgsConstructor
public enum ChatModel {

    TEXT_DAVINCI_003("text-davinci-003"),


    ;
    private final String type;


}
