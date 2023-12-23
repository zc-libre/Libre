package com.libre.framework.blog.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.Tag;
import com.libre.framework.blog.pojo.dto.TagCriteria;
import com.libre.framework.blog.pojo.dto.TagDTO;
import com.libre.framework.blog.service.TagService;
import com.libre.toolkit.result.R;
import com.libre.toolkit.validation.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blog/tag")
public class TagAdminController {

	private final TagService tagService;

	@GetMapping("/all")
	public R<List<Tag>> listAll() {
		List<Tag> list = tagService.list();
		return R.data(list);
	}

	@GetMapping("/page")
	public R<PageDTO<Tag>> findByPage(PageDTO<Tag> page, TagCriteria criteria) {
		PageDTO<Tag> result = tagService.findByPage(page, criteria);
		return R.data(result);
	}

	@PostMapping("/list")
	public R<List<Tag>> findList(@RequestBody TagCriteria criteria) {
		List<Tag> tags = tagService.findList(criteria);
		return R.data(tags);
	}

	@PostMapping("/save")
	public R<Boolean> save(@Validated @RequestBody TagDTO tag) {
		tagService.add(tag);
		return R.status(true);
	}

	@PostMapping("/update")
	public R<Boolean> update(@Validated(UpdateGroup.class) @RequestBody TagDTO tag) {
		tagService.edit(tag);
		return R.status(true);
	}

	@PostMapping("/delete")
	public R<Boolean> deleteByIds(@RequestBody List<Long> ids) {
		tagService.removeByIds(ids);
		return R.status(true);
	}

}
