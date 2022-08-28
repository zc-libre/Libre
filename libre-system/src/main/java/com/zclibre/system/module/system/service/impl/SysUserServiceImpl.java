package com.zclibre.system.module.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.*;
import com.libre.mybatis.util.PageUtil;
import com.libre.toolkit.exception.LibreException;
import com.zclibre.system.module.security.service.dto.UserInfo;
import com.zclibre.system.module.system.dto.UserCriteria;
import com.zclibre.system.module.system.entity.SysRole;
import com.zclibre.system.module.system.entity.SysUser;
import com.zclibre.system.module.system.entity.SysUserRole;
import com.zclibre.system.module.system.mapper.SysUserMapper;
import com.zclibre.system.module.system.service.SysRoleService;
import com.zclibre.system.module.system.service.SysUserRoleService;
import com.zclibre.system.module.system.service.SysUserService;
import com.zclibre.system.module.system.service.convert.SysUserConvert;
import com.zclibre.system.module.system.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.zclibre.common.constant.CacheConstants.SYS_USER_CACHE;

/**
 * @author zhao.cheng
 */
@Service
@CacheConfig(cacheNames = SYS_USER_CACHE)
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	private final SysRoleService roleService;

	private final SysUserRoleService userRoleService;

	@Override
	public IPage<UserVO> findByPage(Page<SysUser> page, UserCriteria userParam) {
		Page<SysUser> userPage = this.page(page, getQueryWrapper(userParam));
		List<SysUser> records = userPage.getRecords();
		if (CollectionUtils.isEmpty(records)) {
			return null;
		}

		Multimap<Long, Long> userIdRoleMap = LinkedHashMultimap.create();
		Set<Long> roleIdSet = Sets.newHashSet();

		Set<Long> userIdSet = records.stream().map(SysUser::getId).collect(Collectors.toSet());
		List<SysUserRole> userRoleList = userRoleService.getListByUserIds(userIdSet);

		if (CollectionUtils.isNotEmpty(userRoleList)) {
			for (SysUserRole sysUserRole : userRoleList) {
				userIdRoleMap.put(sysUserRole.getUserId(), sysUserRole.getRoleId());
				roleIdSet.add(sysUserRole.getRoleId());
			}
		}

		Map<Long, SysRole> roleMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(roleIdSet)) {
			Map<Long, SysRole> map = roleService.listByIds(roleIdSet).stream()
					.collect(Collectors.toMap(SysRole::getId, Function.identity()));
			roleMap.putAll(map);
		}

		List<UserVO> vos = Lists.newArrayList();
		for (SysUser sysUser : records) {
			UserVO userVO = SysUserConvert.INSTANCE.sourceToTarget(sysUser);
			// 角色
			Collection<Long> roleIds = userIdRoleMap.get(sysUser.getId());
			List<SysRole> roleList = Lists.newArrayList();
			if (CollectionUtils.isNotEmpty(roleIds)) {
				roleIds.forEach(roleId -> roleList.add(roleMap.get(roleId)));
			}
			userVO.setRoles(roleList);
			vos.add(userVO);
		}
		return PageUtil.toPage(userPage, vos);
	}

	@Override
	// @Cacheable(key = "#id")
	public SysUser findUserById(Long id) {
		return baseMapper.selectById(id);
	}

	@Override
	public SysUser getByUsername(String username) {
		return this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
	}

	@Override
	public boolean updateByUsername(String username, SysUser sysUser) {
		LambdaUpdateWrapper<SysUser> wrapper = Wrappers.<SysUser>lambdaUpdate().eq(SysUser::getUsername, username);
		return this.update(sysUser, wrapper);
	}

	@Override
	public UserInfo findUserInfoByUsername(String username) {
		SysUser sysUser = Optional.ofNullable(this.getByUsername(username))
				.orElseThrow(() -> new LibreException(String.format("用户不存在, username,: [%s]", username)));
		List<SysRole> roles = roleService.getListByUserId(sysUser.getId());
		List<String> permissions = Lists.newArrayList();
		if (CollectionUtils.isNotEmpty(roles)) {
			 permissions = roles.stream().map(SysRole::getTitle).collect(Collectors.toList());
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setAvatar(sysUser.getAvatar());
		userInfo.setPermissions(permissions);
		return userInfo;
	}

	private Wrapper<SysUser> getQueryWrapper(UserCriteria param) {
		String blurry = param.getBlurry();
		LambdaQueryWrapper<SysUser> wrapper = Wrappers.<SysUser>lambdaQuery().nested(param.isBlurryQuery(),
				q -> q.like(SysUser::getEmail, blurry).or().like(SysUser::getEmail, blurry).or()
						.like(SysUser::getNickName, blurry));
		if (param.haveTime()) {
			wrapper.between(SysUser::getGmtCreate, param.getStartTime(), param.getEndTime());
		}
		return wrapper;
	}

}
