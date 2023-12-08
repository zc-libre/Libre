package com.libre.framework.blog.pojo.dto;

import com.libre.framework.common.base.BaseCriteria;
import lombok.*;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagCriteria extends BaseCriteria {


    private Collection<Long> tagIds;
}
