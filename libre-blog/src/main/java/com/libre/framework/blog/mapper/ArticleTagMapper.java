package com.libre.framework.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libre.framework.blog.pojo.ArticleTag;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

	void deleteByArticleIds(List<Long> ids);

}
