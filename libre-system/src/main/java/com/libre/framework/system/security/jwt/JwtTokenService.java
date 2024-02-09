package com.libre.framework.system.security.jwt;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.google.common.base.Charsets;
import com.libre.framework.system.security.configuration.LibreSecurityProperties;
import com.libre.framework.system.security.oauth2.SerializableToken;
import com.libre.toolkit.core.StringUtil;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * token 验证处理
 *
 * @author L.cm
 */
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class JwtTokenService implements SmartInitializingSingleton {

	/**
	 * 令牌前缀
	 */
	public static final String TOKEN_PREFIX = "Bearer ";

	private final LibreSecurityProperties properties;

	private JwtParser jwtParser;

	private final JwtEncoder jwtEncoder;

	/**
	 * 获取 token
	 * @param request HttpServletRequest
	 * @return token
	 */
	public String getToken(HttpServletRequest request) {
		LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
		// 1. 获取请求头携带的令牌
		String tokenHeaderKey = jwtToken.getHeader();
		String token = request.getHeader(tokenHeaderKey);
		// 2. 获取参数传递的 token
		if (StringUtil.isBlank(token)) {
			token = request.getParameter(tokenHeaderKey);
		}
		// 3. 解析 Bearer token
		if (StringUtil.isNotBlank(token) && token.startsWith(TOKEN_PREFIX)) {
			token = token.substring(TOKEN_PREFIX.length());
		}
		// 4. 如果为空返回
		if (StringUtil.isBlank(token)) {
			return null;
		}
		return token;
	}


	public String getToken(ServerHttpRequest request) {
		LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
		// 1. 获取请求头携带的令牌
		String tokenHeaderKey = jwtToken.getHeader();
		HttpHeaders headers = request.getHeaders();
		List<String> tokens = headers.get(tokenHeaderKey);
		if (CollectionUtils.isEmpty(tokens)) {
			return null;
		}
		String token = tokens.get(0);
		// 3. 解析 Bearer token
		if (StringUtil.isNotBlank(token) && token.startsWith(TOKEN_PREFIX)) {
			token = token.substring(TOKEN_PREFIX.length());
		}
		return token;
	}

	/**
	 * 获取用户身份信息
	 * @return 用户信息
	 */
	public String getSubject(HttpServletRequest request) {
		String token = getToken(request);
		return getSubject(token);
	}

	/**
	 * 获取用户身份信息
	 * @return 用户信息
	 */
	public String getSubject(String token) {
		if (StringUtil.isBlank(token)) {
			return null;
		}
		// 注意此处 有几个异常需要处理
		Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
		Claims body = claimsJws.getBody();
		if (body == null) {
			return null;
		}
		return body.getSubject();
	}

	/**
	 * 创建令牌
	 * @param username AuthUser
	 * @param now 当前时间
	 * @param expireTime 有效期
	 * @return 令牌
	 */
	public String createToken(String username, Date now, Duration expireTime) {
		// jwt token 配置信息
		LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
		String secret = jwtToken.getSecret();
		SignatureAlgorithm algorithm = jwtToken.getSignatureAlgorithm();
		// 加密 key
		Key keySpec = new SecretKeySpec(secret.getBytes(Charsets.UTF_8), algorithm.getJcaName());
		return Jwts.builder()
			.setId(IdWorker.get32UUID())
			.setAudience(jwtToken.getAudience())
			.setIssuer(jwtToken.getIssuer())
			.setIssuedAt(now)
			.setSubject(username)
			.setNotBefore(now)
			.setExpiration(DateUtils.addMilliseconds(now, (int) expireTime.toMillis()))
			.signWith(keySpec)
			.compact();
	}

	public String createOauth2Token(SerializableToken serializableToken, Duration expireTime) {
		LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
		Instant now = Instant.now();
		JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(jwtToken.getIssuer())
				.issuedAt(now)
				.subject(serializableToken.getUsername())
				.expiresAt(now.plusSeconds(expireTime.getSeconds()))
				.build();

		return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}


	@Override
	public void afterSingletonsInstantiated() {
		// jwt token 配置信息
		LibreSecurityProperties.JwtToken jwtToken = properties.getJwtToken();
		String secret = jwtToken.getSecret();
		SignatureAlgorithm algorithm = jwtToken.getSignatureAlgorithm();
		// 加密 key
		Key keySpec = new SecretKeySpec(secret.getBytes(Charsets.UTF_8), algorithm.getJcaName());
		// jwtParser
		jwtParser = Jwts.parserBuilder().setSigningKey(keySpec).build();
	}

}
