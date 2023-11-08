package com.libre.framework.blog.controller;

import com.libre.framework.blog.pojo.dto.ArticleDTO;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.framework.blog.service.ArticleService;
import com.libre.framework.log.annotation.ApiLog;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blog/article")
public class ArticleAdminController {


    private final ArticleService articleService;

    @ApiLog("添加文章")
    @PostMapping("/add")
    public R<Boolean> saveArticle(@RequestBody ArticleDTO article) {
        articleService.add(article);
        return R.status(true);
    }

    @GetMapping("/{id}")
    public R<ArticleVO> get(@PathVariable Long id) {
        ArticleVO articleVO = articleService.getArticleById(id);
        return R.data(articleVO);
    }

    @ApiLog("更新文章")
    @PostMapping("/update")
    public R<Boolean> updateArticle(@RequestBody ArticleDTO article) {
        articleService.edit(article);
        return R.status(true);
    }


    @PostMapping
    public R<Boolean> delete(@RequestBody List<Long> ids) {
        articleService.removeByIds(ids);
        return R.status(true);
    }
}
