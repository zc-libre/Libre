package com.libre.framework.system.security.jwt;

import com.libre.boot.toolkit.RequestUtils;
import com.libre.toolkit.result.R;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// 没有权限 403
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		RequestUtils.renderJson(response, R.fail("没有权限访问"));

	}

}
