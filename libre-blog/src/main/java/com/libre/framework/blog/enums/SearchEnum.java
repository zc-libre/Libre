package com.libre.framework.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchEnum {

	SQL(1),

	ES(2),
	;

	private final Integer value;

}
