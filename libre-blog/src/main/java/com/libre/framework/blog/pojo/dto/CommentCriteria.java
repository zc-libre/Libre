package com.libre.framework.blog.pojo.dto;

import com.libre.framework.common.base.BaseCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommentCriteria extends BaseCriteria {

	private Long topicId;

	private Long userId;

	private Long parentId;

	private String commentContent;

	private Integer commentType;

	private Integer review;

	private Long replyUserId;

	private Integer limit;

	private Collection<Long> ids;

	private Collection<Long> parentIds;

}
