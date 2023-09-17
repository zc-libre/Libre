package com.libre.framework.im.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libre.framework.im.pojo.ChatMessage;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Libre
 * @Date: 2022/5/23 10:52 PM
 */
@Mapper
public interface MessageMapper extends BaseMapper<ChatMessage> {
}
