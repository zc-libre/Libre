package com.libre.admin.module.security.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.libre.admin.module.security.auth.AuthUser;
import com.libre.admin.module.security.pojo.RoleInfo;
import com.libre.admin.module.security.utils.SecurityUtil;
import com.libre.admin.module.system.entity.*;
import com.libre.admin.module.system.service.*;
import com.libre.admin.module.system.service.convert.SysDeptConvert;
import com.libre.admin.module.system.service.convert.SysPostConvert;
import com.libre.admin.module.system.service.convert.SysRoleConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.libre.admin.common.constant.LibreConstants.PASSWORD_PREFIX;

/**
 * @author ZC
 * @date 2021/7/12 14:09
 */
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService, UserDetailsPasswordService, UserLockService {

    private final SysUserService userService;
    private final SysRoleService sysRoleService;
    private final SysMenuService sysMenuService;
    private final SysDeptService deptService;
    private final SysPostService postService;
    private final SysRoleConvert roleConvert;
    private final SysDeptConvert deptConvert;
    private final SysPostConvert postConvert;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StrUtil.isBlank(username)) {
            throw new UsernameNotFoundException("userName is blank!");
        }
        SysUser sysUser = userService.getByUsername(username);
        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("User is not found!");
        }
        Long userId = sysUser.getId();
        Boolean isAdmin = sysUser.getIsAdmin();
        List<SysRole> roleList = sysRoleService.getListByUserId(userId);
        Set<String> dbAuthSet = Sets.newHashSet();
        List<RoleInfo> roleInfoList = Lists.newArrayList();
        if (CollUtil.isNotEmpty(roleList)) {
            roleInfoList.addAll(roleConvert.sourceToTarget(roleList));
            // 获取角色
            loadRoleAuthorities(roleList, dbAuthSet);
            // 获取资源，超级管理员有所有资源
            loadUserAuthorities(roleList, dbAuthSet, isAdmin);
        }
        String password = sysUser.getPassword();
        Boolean enabled = sysUser.getEnabled();
        boolean accountNonLocked = !sysUser.getLocked();
        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(dbAuthSet.toArray(new String[0]));
        Long deptId = sysUser.getDeptId();
        SysDept sysDept = null;
        if (Objects.nonNull(deptId)) {
            sysDept = deptService.getById(deptId);
        }

        List<SysPost> postList = postService.getListByUserId(userId);

        AuthUser authUser = new AuthUser(username, PASSWORD_PREFIX + password, enabled, accountNonLocked, authorities);
        authUser.setUserId(sysUser.getId());
        authUser.setNickName(sysUser.getNickName());
        authUser.setIsAdmin(sysUser.getIsAdmin());
        authUser.setGender(sysUser.getGender());
        authUser.setEmail(sysUser.getEmail());
        authUser.setPhone(sysUser.getPhone());
        authUser.setAvatar(sysUser.getAvatar());
        if (Objects.nonNull(sysDept)) {
            authUser.setDept(deptConvert.sourceToTarget(sysDept));
        }
        if (CollUtil.isNotEmpty(postList)) {
            authUser.setPostList(postConvert.sourceToTarget(postList));
        }
        if (CollUtil.isNotEmpty(roleInfoList)) {
            authUser.setRoleList(roleInfoList);
        }
        return authUser;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        AuthUser authUser = (AuthUser) user;
        SysUser sysUser = new SysUser();
        sysUser.setId(authUser.getUserId());
        sysUser.setPassword(newPassword);
        userService.updateById(sysUser);
        return AuthUser.formLibreUser(authUser, newPassword);
    }


    @Override
    public boolean updateLockUser(AuthUser authUser) {
        SysUser sysUser = new SysUser();
        sysUser.setId(authUser.getUserId());
        sysUser.setLocked(Boolean.TRUE);
        return userService.updateById(sysUser);
    }

    private void loadRoleAuthorities(List<SysRole> roleList, Set<String> dbAuthsSet) {
        roleList.stream().map(SysRole::getTitle)
                .filter(StrUtil::isNotBlank)
                .forEach(x -> dbAuthsSet.add(SecurityUtil.SECURITY_ROLE_PREFIX + x));
    }

    private void loadUserAuthorities(List<SysRole> roleList, Set<String> dbAuthSet, Boolean isAdmin) {
        List<SysMenu> menuList;
        // 超级管理员有所有资源权限
        if (Boolean.TRUE.equals(isAdmin)) {
            menuList = sysMenuService.list();
        } else {
            Set<Long> roleIds = roleList.stream()
                    .map(SysRole::getId)
                    .collect(Collectors.toSet());
            menuList = sysMenuService.getListByRoleIds(roleIds);
        }
        menuList.stream()
                .map(SysMenu::getPermission)
                .filter(StrUtil::isNotBlank)
                .forEach(dbAuthSet::add);
    }
}
