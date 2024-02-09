package com.libre.framework.blog.controller.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.Comment;
import com.libre.framework.blog.pojo.dto.CommentCriteria;
import com.libre.framework.blog.pojo.dto.CommentDTO;
import com.libre.framework.blog.pojo.vo.CommentPage;
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

	@GetMapping("/page")
	public R<CommentPage> page(PageDTO<Comment> page, CommentCriteria criteria) {
		CommentPage commentPage = commentService.findByPage(page, criteria);
		return R.data(commentPage);
	}

	@PostMapping("/save")
	public R<Long> save(@RequestBody CommentDTO comment) {
		Long commentId = commentService.add(comment);
		return R.data(commentId);
	}


}
