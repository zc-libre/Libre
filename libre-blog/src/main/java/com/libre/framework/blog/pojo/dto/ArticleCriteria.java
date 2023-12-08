package com.libre.framework.blog.pojo.dto;

import com.libre.framework.common.base.BaseCriteria;
import lombok.*;

import java.util.Collection;

@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCriteria extends BaseCriteria {


    private Long categoryId;

    private Collection<Long> articleIds;
}
