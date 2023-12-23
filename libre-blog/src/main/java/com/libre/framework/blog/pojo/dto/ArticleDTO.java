package com.libre.framework.blog.pojo.dto;

import com.libre.toolkit.validation.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ArticleDTO {

	@NotNull(groups = UpdateGroup.class)
	private Long id;

	@NotBlank
	private String cover;

	@NotBlank
	private String articleName;

	@NotBlank
	private String summary;

	@NotBlank
	private String content;

	private Integer status;

	private Integer top;

	private Integer featured;

	@NotNull
	private Long categoryId;

	@NotNull
	private List<Long> tagIds;

}
