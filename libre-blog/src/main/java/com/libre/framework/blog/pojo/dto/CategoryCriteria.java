package com.libre.framework.blog.pojo.dto;

import com.libre.framework.common.base.BaseCriteria;
import lombok.*;

import java.util.Collection;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCriteria extends BaseCriteria {


    private Collection<Long> categoryIds;
}
