package com.libre.framework.blog.pojo.dto;

import com.libre.framework.common.base.BaseCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.checkerframework.checker.units.qual.C;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BlogUserCriteria extends BaseCriteria {

	private Long userId;

	private Collection<Long> userIds;

}
