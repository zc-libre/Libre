package com.libre.framework.security.oauth2.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.libre.framework.security.oauth2.mapper.OAuth2ClientDetailsMapper;
import com.libre.framework.security.oauth2.service.mapstruct.OAuth2ClientDetailsMapping;
import com.libre.framework.security.pojo.SysOauth2ClientDetails;
import com.libre.security.pojo.Oauth2ClientDetails;
import com.libre.security.service.OAuth2ClientDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Libre
 * @Date: 2023/1/28 11:54 PM
 */
@Component
@RequiredArgsConstructor
public class OAuth2ClientDetailsServiceImpl implements OAuth2ClientDetailsService {

	private final OAuth2ClientDetailsMapper clientDetailsMapper;

	@Override
	public Oauth2ClientDetails getClientDetailsById(String clientId) {
		return clientDetailsMapper.selectOne(
				Wrappers.<SysOauth2ClientDetails>lambdaQuery().eq(SysOauth2ClientDetails::getClientId, clientId));
	}

	@Override
	public List<Oauth2ClientDetails> listClientDetails() {
		List<SysOauth2ClientDetails> detailsList = clientDetailsMapper.selectList(null);
		OAuth2ClientDetailsMapping mapping = OAuth2ClientDetailsMapping.INSTANCE;
		return mapping.sourceToTarget(detailsList);
	}

}
