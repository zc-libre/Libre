package com.libre.admin.framework.security.auth;

import cn.hutool.core.util.StrUtil;
import com.libre.core.toolkit.StringPool;
import lombok.Getter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZC
 * @date 2021/7/12 10:30
 */
@Getter
public class LibreWebAuthenticationDetails extends WebAuthenticationDetails {

    private final String validateCodeId;
    private final String validateCode;
    private final boolean rememberMe;

    LibreWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.validateCodeId = request.getParameter("validateCodeId");
        this.validateCode = request.getParameter("validateCode");
        this.rememberMe = getRememberMe(request.getParameter("remember-me"));
    }

    private static boolean getRememberMe(String value) {
        if (StrUtil.isBlank(value)) {
            return false;
        }
        if (StringPool.ONE.equals(value)) {
            return true;
        }
        return StringPool.TRUE.equalsIgnoreCase(value);
    }
}
