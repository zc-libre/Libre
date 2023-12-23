package com.libre.framework.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.vo.Archive;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper extends BaseMapper<Article> {

	PageDTO<Archive> findArchiveByPage(@Param("page") PageDTO<Archive> page,
			@Param(Constants.WRAPPER) ArticleCriteria criteria);

	PageDTO<ArticleVO> findPageByTagId(@Param("page") PageDTO<ArticleVO> page, @Param("criteria") ArticleCriteria criteria);
}
