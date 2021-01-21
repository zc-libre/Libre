package com.libre.common.exception;

import com.libre.common.tookit.result.R;
import com.libre.common.tookit.result.SystemCode;
import io.undertow.util.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public R handleException(Throwable e){
        // 打印堆栈信息
        e.printStackTrace();
        return R.fail(e.getMessage());
    }

    /**
     * BadCredentialsException
     */
    @ExceptionHandler(BadCredentialsException.class)
    public R badCredentialsException(BadCredentialsException e){
        // 打印堆栈信息
        String message = "坏的凭证".equals(e.getMessage()) ? "用户名或密码不正确" : e.getMessage();
        log.error(message);
        return R.fail(SystemCode.REQ_REJECT);
    }

    /**
     * 处理自定义异常
     */
	@ExceptionHandler(value = BadRequestException.class)
	public R badRequestException(BadRequestException e) {
        // 打印堆栈信息
        e.printStackTrace();
        return R.fail(SystemCode.REQ_REJECT);
	}
}
