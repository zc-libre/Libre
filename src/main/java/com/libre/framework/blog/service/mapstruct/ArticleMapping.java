package com.libre.framework.blog.service.mapstruct;

import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleDTO;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapping extends BaseMapping<ArticleDTO, Article> {

    ArticleMapping INSTANCE = Mappers.getMapper(ArticleMapping.class);

    ArticleVO convertToVO(Article article);
}
