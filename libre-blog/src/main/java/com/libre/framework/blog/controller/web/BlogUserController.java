package com.libre.framework.blog.controller.web;

import com.libre.framework.blog.pojo.BlogUser;
import com.libre.framework.blog.pojo.dto.Author;
import com.libre.framework.blog.service.BlogUserService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/blog/user")
@RequiredArgsConstructor
public class BlogUserController {

	private final BlogUserService blogUserService;

	@GetMapping("/author")
	public R<Author> author() {
		Author author = blogUserService.getBlogAuthor();
		return R.data(author);
	}

	@GetMapping("{id}")
	public R<BlogUser> getById(@PathVariable Long id) {
		return null;
	}

}
