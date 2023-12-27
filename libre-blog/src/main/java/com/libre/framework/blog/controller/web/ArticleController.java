package com.libre.framework.blog.controller.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.vo.About;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.vo.Archive;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.framework.blog.pojo.vo.Statistic;
import com.libre.framework.blog.pojo.vo.TopAndFeaturedArticleVO;
import com.libre.framework.blog.service.ArticleService;
import com.libre.framework.blog.service.StatisticService;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web/blog/article")
public class ArticleController {

	private final ArticleService articleService;

	private final StatisticService statisticService;

	@GetMapping("/topAndFeaturedArticles")
	public R<TopAndFeaturedArticleVO> findTopAndFeaturedArticles() {
		TopAndFeaturedArticleVO topAndFeaturedArticle = articleService.findTopAndFeaturedArticles();
		return R.data(topAndFeaturedArticle);
	}

	@GetMapping("/page")
	public R<PageDTO<ArticleVO>> page(PageDTO<Article> page, ArticleCriteria criteria) {
		PageDTO<ArticleVO> result = articleService.findByPage(page, criteria);
		return R.data(result);
	}

	@GetMapping("/tagPage")
	public R<PageDTO<ArticleVO>> tagPage(PageDTO<ArticleVO> page, ArticleCriteria criteria) {
		PageDTO<ArticleVO> result = articleService.findPageByTagId(page, criteria);
		return R.data(result);
	}

	@GetMapping("/{id}")
	public R<ArticleVO> get(@PathVariable Long id) {
		ArticleVO article = articleService.getArticleById(id);
		return R.data(article);
	}

	@GetMapping("/statistic")
	public R<Statistic> statistic() {
		Statistic statistic = statisticService.statistic();
		return R.data(statistic);
	}

	@GetMapping("/archives")
	public R<PageDTO<Archive>> archives(PageDTO<Article> page, ArticleCriteria criteria) {
		PageDTO<Archive> result = articleService.findArchives(page, criteria);
		return R.data(result);
	}

	@GetMapping("/about")
	public R<About> archives() {
		About about = articleService.findAboutMe();
		return R.data(about);
	}

}
