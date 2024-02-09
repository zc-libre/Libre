package com.libre.framework.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.framework.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("blog_article")
@Document(indexName = "video", createIndex = false)
public class Article extends BaseEntity {

	private String cover;

	private String articleName;

	private String summary;

	private String content;

	private Integer status;

	private Integer top;

	private Integer featured;

	private Long categoryId;

	private Integer enableComment;

	private Integer articleType;

}
