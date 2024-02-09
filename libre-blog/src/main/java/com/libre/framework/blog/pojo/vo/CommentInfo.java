package com.libre.framework.blog.pojo.vo;

import com.libre.framework.blog.pojo.BlogUser;
import lombok.Data;

import java.util.List;

@Data
public class CommentInfo {

    private Long id;

    private Long topicId;

    private Long userId;

    private Long parentId;

    private String commentContent;

    private Integer commentType;

    private Integer review;

    private Long replyUserId;

    private BlogUser user;

    private List<CommentVO> reply;
}
