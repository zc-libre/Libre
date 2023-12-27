package com.libre.framework.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@TableName("blog_friend_link")
public class FriendLink {

	private Long id;

	private String name;

	private String url;

	private String description;

	private Integer priority;

	private OffsetDateTime createTime;

	private OffsetDateTime updateTime;

}
