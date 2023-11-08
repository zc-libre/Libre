package com.libre.framework.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.dto.CategoryCriteria;
import com.libre.framework.blog.pojo.dto.CategoryDTO;
import com.libre.framework.blog.service.CategoryService;
import com.libre.toolkit.result.R;
import com.libre.toolkit.validation.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/category")
@RequiredArgsConstructor
public class CategoryAdminController {

	private final CategoryService categoryService;

	@GetMapping("/all")
	public R<List<Category>> findAll() {
		List<Category> list = categoryService.list();
		return R.data(list);
	}

	@GetMapping("/page")
	public R<PageDTO<Category>> findByPage(PageDTO<Category> page, CategoryCriteria criteria) {
		PageDTO<Category> result = categoryService.findByPage(page, criteria);
		return R.data(result);
	}

	@PostMapping("/list")
	public R<List<Category>> findList(@RequestBody CategoryCriteria criteria) {
		List<Category> categories = categoryService.findList(criteria);
		return R.data(categories);
	}

	@PostMapping("/add")
	public R<Boolean> save(@Validated @RequestBody CategoryDTO category) {
		categoryService.add(category);
		return R.status(true);
	}

	@PostMapping("/update")
	public R<Boolean> update(@Validated(UpdateGroup.class) @RequestBody CategoryDTO category) {
		categoryService.edit(category);
		return R.status(true);
	}

	@PostMapping("/delete")
	public R<Boolean> deleteByIds(@RequestBody List<Long> ids) {
		categoryService.removeByIds(ids);
		return R.status(true);
	}

}
