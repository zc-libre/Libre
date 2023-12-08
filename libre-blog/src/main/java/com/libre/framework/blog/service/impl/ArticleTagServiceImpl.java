package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.blog.mapper.ArticleTagMapper;
import com.libre.framework.blog.pojo.ArticleTag;
import com.libre.framework.blog.service.ArticleTagService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    @Override
    public void deleteByArticleIds(List<Long> ids) {
       baseMapper.deleteByArticleIds(ids);
    }

    @Override
    public List<ArticleTag> findByArticleIds(Set<Long> articleIds) {
        if (CollectionUtils.isEmpty(articleIds)) {
            return Collections.emptyList();
        }
        return this.list(Wrappers.<ArticleTag>lambdaQuery().in(ArticleTag::getArticleId, articleIds));
    }
}
