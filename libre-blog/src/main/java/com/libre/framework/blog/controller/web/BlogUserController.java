package com.libre.framework.blog.controller.web;

import com.libre.framework.blog.common.CacheConstants;
import com.libre.framework.blog.pojo.BlogUser;
import com.libre.framework.blog.pojo.dto.Author;
import com.libre.framework.blog.pojo.dto.BlogUserDTO;
import com.libre.framework.blog.service.BlogUserService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web/blog/user")
@RequiredArgsConstructor
public class BlogUserController {

	private final BlogUserService blogUserService;

	@GetMapping("/author")
	public R<Author> author() {
		Author author = blogUserService.getBlogAuthor(CacheConstants.BLOG_USER_AUTHOR_KEY);
		return R.data(author);
	}

	@GetMapping("{id}")
	public R<BlogUser> getById(@PathVariable Long id) {
		return null;
	}

}
