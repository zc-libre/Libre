package com.libre.module.oauth.service;


import com.libre.common.tookit.RedisUtils;
import com.libre.module.oauth.prop.SecurityProperties;
import com.libre.module.oauth.service.dto.JwtUserDTO;
import com.libre.module.oauth.service.dto.OnlineUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @author zhao.cheng
 */
@Service
public class OnlineUserService {

    private final SecurityProperties properties;
    private final RedisUtils redisUtils;

    public static final Logger log = LoggerFactory.getLogger(OnlineUserService.class);

    public OnlineUserService(SecurityProperties properties,
                             RedisUtils redisUtils) {
        this.properties = properties;
        this.redisUtils = redisUtils;
    }

    /**
     * 保存在线用户信息
     * @param jwtUserDto /
     * @param token /
     * @param request /
     */
    public void save(JwtUserDTO jwtUserDto, String token, HttpServletRequest request){

        OnlineUserDTO onlineUserDto = null;
        try {
            onlineUserDto = new OnlineUserDTO(jwtUserDto.getUsername(), token, new Date());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        redisUtils.set(properties.getOnlineKey() + token, onlineUserDto, properties.getTokenValidityInSeconds() / 1000);
    }

    /**
     * 查询用户
     * @param key /
     * @return /
     */
    public OnlineUserDTO getOne(String key) {
        return (OnlineUserDTO)redisUtils.get(key);
    }

    /**
     * 退出登录
     * @param token /
     */
    public void logout(String token) {
        String key = properties.getOnlineKey() + token;
        redisUtils.del(key);
    }


}
