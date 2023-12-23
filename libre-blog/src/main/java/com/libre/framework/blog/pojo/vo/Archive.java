package com.libre.framework.blog.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Archive {

	private Long id;

	private String articleName;

	private CreateDate date;

	private String summary;

	private LocalDateTime gmtCreate;

}
