package com.libre.system.module.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.*;
import com.libre.system.module.system.mapper.SysUserMapper;
import com.libre.system.module.system.dto.UserParam;
import com.libre.system.module.system.service.*;
import com.libre.system.module.system.service.convert.SysUserConvert;
import com.libre.system.module.system.vo.UserVO;

import com.libre.mybatis.util.PageUtil;
import com.libre.system.module.system.entity.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.libre.common.constant.CacheConstants.SYS_USER_CACHE;

/**
 * @author zhao.cheng
 */
@Service
@CacheConfig(cacheNames = SYS_USER_CACHE)
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	private final SysDeptService deptService;

	private final SysRoleService roleService;

	private final SysPostService postService;

	private final SysUserPostService userPostService;

	private final SysUserRoleService userRoleService;

	@Override
	public IPage<UserVO> findByPage(Page<SysUser> page, UserParam userParam) {
		Page<SysUser> userPage = this.page(page, getQueryWrapper(userParam));
		List<SysUser> records = userPage.getRecords();
		if (CollectionUtils.isEmpty(records)) {
			return null;
		}
		Set<Long> deptIdSet = Sets.newHashSet();
		Multimap<Long, Long> userIdPostMap = LinkedHashMultimap.create();
		Multimap<Long, Long> userIdRoleMap = LinkedHashMultimap.create();
		Set<Long> postIdSet = Sets.newHashSet();
		Set<Long> roleIdSet = Sets.newHashSet();

		Set<Long> userIdSet = records.stream().map(SysUser::getId).collect(Collectors.toSet());
		List<SysUserPost> userPostList = userPostService.getListByUserIds(userIdSet);
		List<SysUserRole> userRoleList = userRoleService.getListByUserIds(userIdSet);

		if (CollectionUtils.isNotEmpty(userPostList)) {
			for (SysUserPost sysUserPost : userPostList) {
				userIdPostMap.put(sysUserPost.getUserId(), sysUserPost.getPostId());
				postIdSet.add(sysUserPost.getPostId());
			}
		}
		if (CollectionUtils.isNotEmpty(userRoleList)) {
			for (SysUserRole sysUserRole : userRoleList) {
				userIdRoleMap.put(sysUserRole.getUserId(), sysUserRole.getRoleId());
				roleIdSet.add(sysUserRole.getRoleId());
			}
		}

		Map<Long, SysDept> deptMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(deptIdSet)) {
			deptMap = deptService.listByIds(deptIdSet).stream()
					.collect(Collectors.toMap(SysDept::getId, Function.identity()));
		}
		Map<Long, SysRole> roleMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(roleIdSet)) {
			Map<Long, SysRole> map = roleService.listByIds(roleIdSet).stream()
					.collect(Collectors.toMap(SysRole::getId, Function.identity()));
			roleMap.putAll(map);
		}
		Map<Long, SysPost> postMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(postIdSet)) {
			Map<Long, SysPost> map = postService.listByIds(postIdSet).stream()
					.collect(Collectors.toMap(SysPost::getId, Function.identity()));
			postMap.putAll(map);
		}

		List<UserVO> vos = Lists.newArrayList();
		for (SysUser sysUser : records) {
			UserVO userVO = SysUserConvert.INSTANCE.sourceToTarget(sysUser);
			// 部门
			userVO.setDept(deptMap.get(sysUser.getDeptId()));
			// 岗位
			Collection<Long> postIds = userIdPostMap.get(sysUser.getId());
			List<SysPost> postList = Lists.newArrayList();
			if (CollectionUtils.isNotEmpty(postIds)) {
				postIds.forEach(postId -> postList.add(postMap.get(postId)));
			}
			userVO.setPosts(postList);
			// 角色
			Collection<Long> roleIds = userIdRoleMap.get(sysUser.getId());
			List<SysRole> roleList = Lists.newArrayList();
			if (CollectionUtils.isNotEmpty(roleIds)) {
				postIds.forEach(roleId -> roleList.add(roleMap.get(roleId)));
			}
			userVO.setRoles(roleList);
			vos.add(userVO);
		}
		return PageUtil.toPage(userPage, vos);
	}

	@Override
	@Cacheable(key = "#id")
	public SysUser findUserById(Long id) {
		return baseMapper.selectById(id);
	}

	@Override
	public SysUser getByUsername(String username) {
		return this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
	}

	@Override
	public List<SysUser> findListByDeptIds(Collection<Long> deptIds) {
		LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
		wrapper.in(SysUser::getDeptId, deptIds);
		return super.list(wrapper);
	}

	@Override
	public boolean updateByUsername(String username, SysUser sysUser) {
		LambdaUpdateWrapper<SysUser> wrapper = Wrappers.<SysUser>lambdaUpdate().eq(SysUser::getUsername, username);
		return this.update(sysUser, wrapper);
	}

	private Wrapper<SysUser> getQueryWrapper(UserParam param) {

		String blurry = param.getBlurry();
		Long deptId = param.getDeptId();

		Set<Long> deptIds = Sets.newHashSet();
		List<Long> allDeptIds = getAllDeptIds(deptId);
		if (Objects.nonNull(deptId)) {
			deptIds.addAll(allDeptIds);
		}
		LambdaQueryWrapper<SysUser> wrapper = Wrappers.<SysUser>lambdaQuery()
				.nested(param.isBlurryQuery(),
						q -> q.like(SysUser::getEmail, blurry).or().like(SysUser::getEmail, blurry).or()
								.like(SysUser::getNickName, blurry))
				.in(CollectionUtils.isNotEmpty(deptIds), SysUser::getDeptId, deptIds);
		if (param.haveTime()) {
			wrapper.between(SysUser::getGmtCreate, param.getStartTime(), param.getEndTime());
		}
		return wrapper;
	}

	private List<Long> getAllDeptIds(Long deptId) {
		// 获取父类所有的部门
		if (Objects.isNull(deptId)) {
			return Collections.emptyList();
		}
		SysDept sysDept = deptService.getById(deptId);
		List<SysDept> deptList = new ArrayList<>();
		List<SysDept> superiorList = deptService.getChildren(Collections.singletonList(deptId), deptList);
		if (Objects.nonNull(sysDept)) {
			superiorList.add(sysDept);
		}
		return superiorList.stream().map(SysDept::getId).distinct().collect(Collectors.toList());
	}

}
