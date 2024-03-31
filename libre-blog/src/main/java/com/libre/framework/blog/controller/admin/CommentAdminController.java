package com.libre.framework.blog.controller.admin;

import com.libre.framework.blog.pojo.dto.CommentDTO;
import com.libre.framework.blog.service.CommentService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/comment")
@RequiredArgsConstructor
public class CommentAdminController {

	private final CommentService commentService;

	@PostMapping("/save")
	public R<Long> save(@RequestBody CommentDTO comment) {
		Long commentId = commentService.add(comment);
		return R.data(commentId);
	}

}
