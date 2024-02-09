package com.libre.framework.blog.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.libre.framework.blog.pojo.BlogUser;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentVO {

	private Long id;

	private Long topicId;

	@JsonProperty("uid")
	private Long userId;

	private Long parentId;

	@JsonProperty("content")
	private String commentContent;

	private Integer commentType;

	private String os;

	private String browser;

	private String address;

	private Integer review;

	private Long replyUserId;

	private BlogUser user;

	private ReplyComment reply;

	@JsonProperty("createTime")
	private LocalDateTime gmtCreate;

	@Data
	public static class ReplyComment {

		private Integer total;

		private List<CommentVO> list;

	}

}
