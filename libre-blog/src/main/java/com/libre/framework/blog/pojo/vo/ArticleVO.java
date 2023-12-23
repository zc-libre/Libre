package com.libre.framework.blog.pojo.vo;

import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.Tag;
import com.libre.framework.blog.pojo.dto.Author;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleVO {

	private Long id;

	private String cover;

	private String articleName;

	private String summary;

	private String content;

	private Integer status;

	private Integer top;

	private Integer featured;

	private Long categoryId;

	private List<Tag> tags;

	private Category category;

	private Author author;

	private CreateDate date;

	private Integer enableComment;

	private Integer isAbout;

	private ArticleCount count;

	/**
	 * 创建时间
	 */
	private LocalDateTime gmtCreate;

	/**
	 * 更新时间
	 */
	private LocalDateTime gmtModified;

	/**
	 * 创建人
	 */
	private String gmtCreateName;

	/**
	 * 更新人
	 */
	private String gmtModifiedName;

}
