package com.libre.framework.system.security.oauth2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 自定义GrantedAuthoritiesMapper
 * 该类对返回的{@link GrantedAuthority}进一步做处理，返回也是{@link GrantedAuthority}
 *
 * @author bty
 * @date 2023/2/5
 * @since 17
 **/
@Component
public class CustomGrantedAuthorityMapper implements GrantedAuthoritiesMapper {

	@Override
	public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
		return authorities.stream()
			.map(grantedAuthority -> (GrantedAuthority) () -> "CustomGrantedAuthoritiesMapper:"
					+ grantedAuthority.getAuthority())
			.collect(Collectors.toList());
	}

}
