package com.libre.framework.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.framework.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("blog_category")
public class Category extends BaseEntity {

	private String categoryName;

}
