package com.libre.framework.blog.pojo.dto;

import com.libre.toolkit.validation.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

	@NotNull(groups = UpdateGroup.class)
	private Long id;

	@NotBlank
	@Size(max = 32)
	private String categoryName;

}
