package com.libre.framework.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.framework.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("blog_article_tag")
public class ArticleTag extends BaseEntity {

	private Long id;

	private Long articleId;

	private Long tagId;

}
