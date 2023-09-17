package com.libre.framework.im.service.mapstruct;

import com.libre.framework.im.pojo.Friend;
import com.libre.framework.im.pojo.LibreUser;
import com.libre.framework.im.pojo.vo.FriendVO;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author: Libre
 * @Date: 2022/5/3 7:55 AM
 */
@Mapper
public interface FriendMapping extends BaseMapping<Friend, FriendVO> {

    FriendMapping INSTANCE = Mappers.getMapper(FriendMapping.class);

    @Mapping(source = "id", target = "friendId")
    FriendVO chatUserToFriendVO(LibreUser user);
}
