package com.libre.framework.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommentType {

	BLOG(1),

	ABOUT(2),

	COMMENT(3),;

	private final Integer value;

}
