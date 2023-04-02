package com.libre.framework.security.oauth2.service.mapstruct;

import com.libre.framework.security.pojo.SysOauth2ClientDetails;
import com.libre.security.pojo.Oauth2ClientDetails;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author: Libre
 * @Date: 2023/1/29 12:05 AM
 */
@Mapper
public interface OAuth2ClientDetailsMapping extends BaseMapping<SysOauth2ClientDetails, Oauth2ClientDetails> {

	OAuth2ClientDetailsMapping INSTANCE = Mappers.getMapper(OAuth2ClientDetailsMapping.class);

}
