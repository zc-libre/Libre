package com.libre.framework.toolkit.moudle.social.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextMessage extends AbstractMessage {

    @Override
    public String getMessage() {
        return (String) super.getMessage();
    }
}
