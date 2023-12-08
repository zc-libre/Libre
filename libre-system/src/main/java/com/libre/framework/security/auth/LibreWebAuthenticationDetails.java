package com.libre.framework.security.auth;

import com.libre.toolkit.core.StringPool;
import com.libre.toolkit.core.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * 添加 验证码字段
 *
 * @author L.cm
 */
@Getter
public class LibreWebAuthenticationDetails extends WebAuthenticationDetails {

	private static final long serialVersionUID = -5705520861298051410L;

	private final boolean rememberMe;

	LibreWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		this.rememberMe = getRememberMe(request.getParameter("remember-me"));
	}

	private static boolean getRememberMe(String value) {
		if (StringUtil.isBlank(value)) {
			return false;
		}
		if (StringPool.ONE.equals(value)) {
			return true;
		}
		return StringPool.TRUE.equalsIgnoreCase(value);
	}

}
