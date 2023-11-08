package com.libre.framework.social.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("social_friend")
public class SocialFriend {

    @TableId
    private Long id;

    private Long userId;

    private Long friendId;

    private LocalDateTime createTime;
}
