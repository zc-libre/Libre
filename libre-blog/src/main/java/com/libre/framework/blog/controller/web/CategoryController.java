package com.libre.framework.blog.controller.web;

import com.libre.framework.blog.pojo.vo.CategoryVO;
import com.libre.framework.blog.service.CategoryService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web/blog/category")
public class CategoryController {

	private final CategoryService categoryService;

	@GetMapping("/list")
	public R<List<CategoryVO>> findAll() {
		List<CategoryVO> voList = categoryService.findVoList();
		return R.data(voList);
	}

}
