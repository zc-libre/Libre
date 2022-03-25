package com.libre.admin.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.libre.admin.module.security.auth.AuthUser;
import com.libre.admin.module.security.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author ZC
 * @date 2021/7/13 16:33
 */
@Component
@Slf4j
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static final String SYSTEM = "System";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("mybatis plus start insert fill ....");
        this.strictInsertFill(metaObject, "gmtCreate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "gmtCreateId", Long.class, getUserId());
        this.strictInsertFill(metaObject, "gmtModifiedId", Long.class, getUserId());
        this.strictInsertFill(metaObject, "gmtCreateName", String.class, getUsername());
        this.strictInsertFill(metaObject, "gmtModifiedName", String.class, getUsername());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("mybatis plus start update fill ....");
        this.strictInsertFill(metaObject, "gmtModifiedId", Long.class, getUserId());
        this.strictInsertFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "gmtModifiedName", String.class, getUsername());
    }

    private Long getUserId() {
        AuthUser user = SecurityUtil.getUser();
        if (Objects.isNull(user)) {
            return -1L;
        }
        Long userId = user.getUserId();
        return userId  == null ? -1 : userId;
    }

    private String getUsername() {
        AuthUser user = SecurityUtil.getUser();
        if (Objects.isNull(user)) {
            return SYSTEM;
        }
        String username = user.getUsername();
        return username  == null ? SYSTEM : username;
    }

}
