package com.libre.framework.blog.controller.web;

import com.libre.framework.blog.common.CacheConstants;
import com.libre.framework.blog.pojo.BlogUser;
import com.libre.framework.blog.pojo.dto.Author;
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

	@GetMapping("/test")
	public String test() {
		System.out.println("Test Result~~~~");
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		Object principal = authentication.getPrincipal();
		System.out.println(principal);
		return authentication.toString();
	}

	@PostMapping("/login")
	public R<String> login() {
		// 创建授权request
		AuthRequest authRequest = new AuthGiteeRequest(AuthConfig.builder()
			.clientId("clientId")
			.clientSecret("clientSecret")
			.redirectUri("redirectUri")
			.build());
		// 生成授权页面
		String state = authRequest.authorize("state");
		// 授权登录后会返回code（auth_code（仅限支付宝））、state，1.8.0版本后，可以用AuthCallback类作为回调接口的参数
		// 注：JustAuth默认保存state的时效为3分钟，3分钟内未使用则会自动清除过期的state
		return R.data(state);
	}

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
