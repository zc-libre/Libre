package com.libre.framework.blog.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommentDTO {

	private Long id;

	private Long topicId;

	@JsonProperty("uid")
	private Long userId;

	private Long parentId;

	@JsonProperty("content")
	private String commentContent;

	private Integer commentType;

	private Long replyUserId;

	@Data
	public static class CommentUser {

		private Long id;

		private String username;

		private String avatar;

	}

}
