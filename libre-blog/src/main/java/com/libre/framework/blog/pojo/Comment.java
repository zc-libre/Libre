package com.libre.framework.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.framework.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("blog_comment")
public class Comment extends BaseEntity {

	private Long topicId;

	private Long userId;

	private Long parentId;

	private String commentContent;

	private Integer commentType;

	private Integer review;

	private Long replyUserId;

	private String os;

	private String browser;

	private String address;

}
