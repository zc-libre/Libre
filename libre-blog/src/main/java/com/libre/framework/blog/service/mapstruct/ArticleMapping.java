package com.libre.framework.blog.service.mapstruct;

import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleDTO;
import com.libre.framework.blog.pojo.dto.ArticleIndex;
import com.libre.framework.blog.pojo.vo.Archive;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArticleMapping extends BaseMapping<ArticleDTO, Article> {

	ArticleMapping INSTANCE = Mappers.getMapper(ArticleMapping.class);

	ArticleVO convertToVO(Article article);

	List<ArticleVO> convertToVoList(List<Article> voList);

	List<Archive> convertToArchiveList(List<Article> voList);

	List<ArticleIndex> convertToArticleIndexList(List<Article> articleList);

}
