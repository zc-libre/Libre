package com.libre.framework.blog.pojo.dto;

import com.libre.toolkit.validation.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TagDTO {

	@NotNull(groups = UpdateGroup.class)
	private Long id;

	@NotBlank
	@Size(max = 32)
	private String tagName;

}
