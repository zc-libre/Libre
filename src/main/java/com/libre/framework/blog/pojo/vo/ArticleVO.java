package com.libre.framework.blog.pojo.vo;

import lombok.Data;

@Data
public class ArticleVO {

    private Long id;

    private String cover;

    private String articleName;

    private String summary;

    private String content;

    private Integer status;

    private Integer top;

    private Integer featured;

}
