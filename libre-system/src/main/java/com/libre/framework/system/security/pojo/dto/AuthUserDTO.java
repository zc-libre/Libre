package com.libre.framework.system.security.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class AuthUserDTO {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
