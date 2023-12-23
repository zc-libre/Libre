package com.libre.framework.blog.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.dto.ArticleDTO;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.framework.blog.service.ArticleService;
import com.libre.framework.toolkit.moudle.log.annotation.ApiLog;
import com.libre.toolkit.result.R;
import com.libre.toolkit.validation.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blog/article")
public class ArticleAdminController {

	private final ArticleService articleService;

	@GetMapping("/page")
	public R<PageDTO<ArticleVO>> page(PageDTO<Article> page, ArticleCriteria criteria) {
		PageDTO<ArticleVO> result = articleService.findByPage(page, criteria);
		return R.data(result);
	}

	@ApiLog("添加文章")
	@PostMapping("/add")
	public R<Boolean> saveArticle(@Validated @RequestBody ArticleDTO article) {
		articleService.addOrUpdate(article);
		return R.status(true);
	}

	@GetMapping("/{id}")
	public R<ArticleVO> get(@PathVariable Long id) {
		ArticleVO articleVO = articleService.getArticleById(id);
		return R.data(articleVO);
	}

	@ApiLog("更新文章")
	@PostMapping("/update")
	public R<Boolean> updateArticle(@Validated(UpdateGroup.class) @RequestBody ArticleDTO article) {
		articleService.edit(article);
		return R.status(true);
	}

	@DeleteMapping
	public R<Boolean> delete(@RequestBody List<Long> ids) {
		articleService.deleteByIds(ids);
		return R.status(true);
	}

}
