package com.libre.framework.blog.controller.web;

import com.libre.framework.blog.pojo.dto.CommentDTO;
import com.libre.framework.blog.pojo.vo.CommentVO;
import com.libre.framework.blog.service.CommentService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/blog/comment")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@GetMapping("/recent")
	public R<List<CommentVO>> recentComments() {
		List<CommentVO> recentComments = commentService.findRecentComments();
		return R.data(recentComments);
	}

	@PostMapping("/save")
	public R<Boolean> save(@RequestBody CommentDTO comment) {
		commentService.add(comment);
		return R.status(true);
	}

	@GetMapping("")
	public void page() {

	}

}
