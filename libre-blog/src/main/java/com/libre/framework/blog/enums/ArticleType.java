package com.libre.framework.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleType {

	BLOG(1),

	ABOUT(2),

	COMMENT(3),;

	private final Integer type;

}
