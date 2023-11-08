package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.blog.mapper.ArticleMapper;
import com.libre.framework.blog.mapper.ArticleTagMapper;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleDTO;
import com.libre.framework.blog.pojo.vo.ArticleVO;
import com.libre.framework.blog.service.ArticleService;
import com.libre.framework.blog.service.mapstruct.ArticleMapping;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    private final ArticleTagMapper articleTagMapper;

    @Override
    public void add(ArticleDTO articleDTO) {
        ArticleMapping mapping = ArticleMapping.INSTANCE;
        Article article = mapping.sourceToTarget(articleDTO);
        List<Long> tagIds = articleDTO.getTagIds();

        this.save(article);
    }

    @Override
    public void edit(ArticleDTO articleDTO) {
        ArticleMapping mapping = ArticleMapping.INSTANCE;
        Article article = mapping.sourceToTarget(articleDTO);
        this.updateById(article);
    }

    @Override
    public ArticleVO getArticleById(Long id) {
        Article article = baseMapper.selectById(id);
        ArticleMapping mapping = ArticleMapping.INSTANCE;
        ArticleVO articleVO = mapping.convertToVO(article);


        return articleVO;
    }


}
