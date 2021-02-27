package com.libre.common.security.util;

import cn.hutool.core.convert.Convert;
import com.libre.common.security.model.SecurityUser;
import com.libre.common.tookit.Builder;
import com.libre.common.tookit.StringPool;
import com.libre.common.tookit.WebUtil;
import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.util.List;

import static com.libre.common.security.constant.TokenConstants.*;

/**
 * @author zhao.cheng
 * @Date 2021/2/28
 */
public class AuthUtils {

    private static final String USER_REQUEST_ATTR = "_USER_REQUEST_ATTR_";

    public static SecurityUser getUser() {
        HttpServletRequest request = WebUtil.getRequest();
        if (request == null) {
            return null;
        }
        // 优先从 request 中获取
        Object user = request.getAttribute(USER_REQUEST_ATTR);
        if (user == null) {
            user = getUser(request);
            // 设置到 request 中
            request.setAttribute(USER_REQUEST_ATTR, user);
        }
        return (SecurityUser) user;
    }

    public static SecurityUser getUser(HttpServletRequest request) {

        String token = JwtUtils.getToken(request);
        Claims claims = JwtUtils.getClaims(token);
        String username = Convert.toStr(claims.get(USERNAME), "");
        String nickName = Convert.toStr(claims.get(NICK_NAME), "");
        List<String> roles = Convert.toList(String.class, claims.get(ROLE_LIST));
        String phone = Convert.toStr(claims.get(PHONE), "");
        Long deptId = Convert.toLong(claims.get(DEPT_ID), -1L);
        Long postId = Convert.toLong(claims.get(POST_ID), -1L);
        Long userId = Convert.toLong(claims.get(USER_ID), -1L);
        List<Long> roleIds = Convert.toList(Long.class, claims.get(ROLE_ID));

        return Builder.of(SecurityUser::new)
                .with(SecurityUser::setId, userId)
                .with(SecurityUser::setUsername, username)
                .with(SecurityUser::setNickName, nickName)
                .with(SecurityUser::setRoles, roles)
                .with(SecurityUser::setRoleIds, roleIds)
                .with(SecurityUser::setDeptId, deptId)
                .with(SecurityUser::setPhone, phone)
                .with(SecurityUser::setPostId, postId)
                .build();

    }


    public static Long getUserId() {
        SecurityUser user = getUser();
        return (null == user) ? -1 : user.getId();
    }

    public static Long getDeptId() {
        SecurityUser user = getUser();
        return (null == user) ? -1 : user.getDeptId();
    }

    public static List<Long> getRoleIds() {
        SecurityUser user = getUser();
        return (null == user) ? Collections.emptyList() : user.getRoleIds();
    }

    public static String getUsername() {
        SecurityUser user = getUser();
        return (null == user) ? StringPool.EMPTY : user.getUsername();
    }

    public static String getNickName() {
        SecurityUser user = getUser();
        return (null == user) ? StringPool.EMPTY : user.getNickName();
    }

    public static List<String> getRoles() {
        SecurityUser user = getUser();
        return (null == user) ? Collections.emptyList() : user.getRoles();
    }

    public static String phone() {
        SecurityUser user = getUser();
        return (null == user) ? StringPool.EMPTY : user.getPhone();
    }
}
