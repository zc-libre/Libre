package com.libre.framework.im.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.im.pojo.Conversation;
import com.libre.framework.im.pojo.vo.ConversationVO;

import java.util.List;

/**
 * @author: Libre
 * @Date: 2022/6/13 10:55 PM
 */
public interface ConversationService extends IService<Conversation> {

    List<ConversationVO> listByUserId(Long userId);

    void removeByUserIdAndFriendId(Long userId, Long friendId);

    void add(Long friend);

}
