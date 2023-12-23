package com.libre.framework.blog.controller.web;

import com.libre.framework.blog.pojo.vo.TagVO;
import com.libre.framework.blog.service.TagService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/web/blog/tag")
@RequiredArgsConstructor
public class TagController {

	private final TagService tagService;

	@GetMapping("/list")
	public R<List<TagVO>> findAll() {
		List<TagVO> voList = tagService.findAllTags();
		return R.data(voList);
	}

}
