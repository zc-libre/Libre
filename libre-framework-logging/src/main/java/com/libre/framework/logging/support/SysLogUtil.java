package com.libre.framework.logging.support;

import com.libre.boot.toolkit.RequestUtils;
import com.libre.framework.common.security.AuthUser;
import com.libre.framework.common.security.SecurityUtil;
import com.libre.toolkit.core.CharPool;
import com.libre.toolkit.core.StringPool;
import com.libre.toolkit.core.StringUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * 系统日志工具类
 */
public class SysLogUtil {

	/**
	 * 构造 SysLogEvent
	 * @param logType SysLogType
	 * @return SysLogEvent
	 */
	public static SysLogEvent buildSysLogEvent(SysLogType logType) {
		SysLogEvent event = new SysLogEvent();
		event.setLogType(logType.name());
		HttpServletRequest request = RequestUtils.getRequest();
		String method = request.getMethod();
		// 请求信息 GET /api/test/xx
		String requestInfo = method + StringPool.SPACE + request.getRequestURI();
		// paraMap
		Map<String, String[]> paraMap = request.getParameterMap();
		if (CollectionUtils.isEmpty(paraMap)) {
			event.setParams(requestInfo);
		}
		else {
			StringBuilder builder = new StringBuilder(requestInfo).append(CharPool.QUESTION_MARK);
			paraMap.forEach((key, values) -> {
				builder.append(key).append(CharPool.EQUALS);
				if ("password".equalsIgnoreCase(key)) {
					builder.append("******");
				}
				else {
					builder.append(StringUtil.join(values));
				}
				builder.append(CharPool.AMPERSAND);
			});
			builder.deleteCharAt(builder.length() - 1);
			event.setParams(builder.toString());
		}
		// 获取请求 ip 和 ua
		event.setRequestIp(RequestUtils.getIp());
		event.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
		// 用户信息
		AuthUser authUser = SecurityUtil.getUser();
		if (Objects.nonNull(authUser)) {
			event.setUserId(authUser.getUserId());
			event.setUserName(authUser.getUsername());
		}
		return event;
	}

}
