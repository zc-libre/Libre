package com.libre.module.system.convert;

import com.libre.module.system.service.dto.UserDTO;
import com.libre.module.system.entity.User;
import org.mapstruct.Mapper;

/**
 * @author zhao.cheng
 * @Date 2021/2/21
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

    /**
     * user ==> userDTO
     * @param user /
     * @return /
     */
    UserDTO toUserDTO(User user);
}
