package com.libre.framework.blog.pojo;

import com.libre.framework.blog.pojo.vo.ArticleCount;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class About {

	private Long id;

	private String content;

	private ArticleCount count;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

}
