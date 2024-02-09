package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.libre.boot.toolkit.RequestUtils;
import com.libre.framework.blog.mapper.CommentMapper;
import com.libre.framework.blog.pojo.BlogUser;
import com.libre.framework.blog.pojo.Comment;
import com.libre.framework.blog.pojo.dto.BlogUserCriteria;
import com.libre.framework.blog.pojo.dto.CommentCriteria;
import com.libre.framework.blog.pojo.dto.CommentDTO;
import com.libre.framework.blog.pojo.vo.CommentPage;
import com.libre.framework.blog.pojo.vo.CommentVO;
import com.libre.framework.blog.service.BlogUserService;
import com.libre.framework.blog.service.CommentService;
import com.libre.framework.blog.service.mapstruct.CommentMapping;
import com.libre.framework.common.constant.LibreConstants;
import com.libre.ip2region.core.Ip2regionSearcher;
import com.libre.mybatis.util.PageUtil;
import com.libre.toolkit.core.INetUtil;
import com.libre.toolkit.core.StringUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

	private final BlogUserService blogUserService;

	private final Ip2regionSearcher searcher;

	@Override
	public List<CommentVO> findRecentComments() {
		CommentCriteria criteria = new CommentCriteria();
		criteria.setParentId(0L);
		criteria.setLimit(6);
		List<Comment> commentList = this.list(buildQueryWrapper(criteria));
		if (CollectionUtils.isEmpty(commentList)) {
			return Collections.emptyList();
		}
		return buildVoList(commentList);
	}

	@Override
	public Long add(CommentDTO commentDTO) {
		CommentMapping mapping = CommentMapping.INSTANCE;
		Comment comment = mapping.convertToComment(commentDTO);
		if (Objects.isNull(comment.getParentId())) {
			comment.setParentId(0L);
		}
		// 获取操作系统和浏览器信息
		setRequestInfo(comment);
		this.save(comment);
		return comment.getId();
	}

	@Override
	public CommentPage findByPage(PageDTO<Comment> page, CommentCriteria criteria) {
		if (Objects.isNull(criteria)) {
			criteria = new CommentCriteria();
		}
		criteria.setParentId(0L);
		PageDTO<Comment> result = this.page(page, buildQueryWrapper(criteria));
		List<Comment> records = result.getRecords();
		CommentPage commentPage = new CommentPage();
		if (CollectionUtils.isEmpty(records)) {
			return commentPage;
		}
		List<CommentVO> voList = buildVoList(records);
		PageDTO<CommentVO> res = PageUtil.toPage(result, voList);
		commentPage.setSize(res.getSize());
		commentPage.setRecords(res.getRecords());
		commentPage.setCurrent(res.getCurrent());
		commentPage.setTotal(res.getTotal());
		return commentPage;
	}

	private List<Comment> findReply(Collection<Long> parentIds) {
		CommentCriteria criteria = new CommentCriteria();
		criteria.setParentIds(parentIds);
		return this.list(buildQueryWrapper(criteria));
	}

	private List<CommentVO> buildVoList(List<Comment> commentList) {
		CommentMapping mapping = CommentMapping.INSTANCE;
		List<CommentVO> voList = mapping.sourceToTarget(commentList);

		Set<Long> parentIds = voList.stream().map(CommentVO::getId).collect(Collectors.toSet());
		List<Comment> replyComments = this.findReply(parentIds);

		if (CollectionUtils.isEmpty(replyComments)) {
			setCommentUser(voList);
			return voList;
		}

		List<CommentVO> reply = mapping.sourceToTarget(replyComments);
		setCommentUser(reply);
		setCommentUser(voList);
		Map<Long, List<CommentVO>> replyMap = reply.stream().collect(Collectors.groupingBy(CommentVO::getParentId));
		for (CommentVO vo : voList) {
			List<CommentVO> replyList = replyMap.get(vo.getId());
			if (CollectionUtils.isNotEmpty(replyList)) {
				CommentVO.ReplyComment replyComment = new CommentVO.ReplyComment();
				replyComment.setTotal(replyList.size());
				replyComment.setList(replyList);
				vo.setReply(replyComment);
			}
		}
		return voList;
	}

	private void setCommentUser(List<CommentVO> voList) {
		Set<Long> userIds = voList.stream().map(CommentVO::getUserId).collect(Collectors.toSet());
		BlogUserCriteria userCriteria = new BlogUserCriteria();
		userCriteria.setUserIds(userIds);
		Map<Long, BlogUser> userMap = findUserAsMap(userCriteria);
		for (CommentVO vo : voList) {
			BlogUser blogUser = userMap.get(vo.getUserId());
			if (Objects.nonNull(blogUser)) {
				vo.setUser(blogUser);
			}
		}
	}

	private Map<Long, BlogUser> findUserAsMap(BlogUserCriteria userCriteria) {
		List<BlogUser> userList = blogUserService.findCriteria(userCriteria);
		Map<Long, BlogUser> userMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(userList)) {
			for (BlogUser blogUser : userList) {
				userMap.put(blogUser.getId(), blogUser);
			}
		}
		return userMap;
	}

	public List<CommentVO> findComment(Long commentId) {
		List<CommentVO> paths = Lists.newArrayList();
		List<CommentVO> parentPath = findParentPath(commentId, paths);
		Collections.reverse(parentPath);
		return paths;
	}

	private List<CommentVO> findParentPath(Long commentId, List<CommentVO> paths) {
		Comment comment = this.getById(commentId);
		CommentMapping mapping = CommentMapping.INSTANCE;
		CommentVO vo = mapping.sourceToTarget(comment);
		paths.add(vo);
		if (Objects.nonNull(comment) && comment.getParentId() != 0) {
			findParentPath(comment.getParentId(), paths);
		}
		return paths;
	}

	private void setRequestInfo(Comment comment) {
		HttpServletRequest request = RequestUtils.getRequest();
		String userAgentStr = request.getHeader(HttpHeaders.USER_AGENT);
		UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
		OperatingSystem system = userAgent.getOperatingSystem();
		Browser browser = userAgent.getBrowser();
		String requestIp = RequestUtils.getIp();
		String requestAddress = getRequestAddress(requestIp);
		comment.setAddress(requestAddress);
		comment.setOs(system.getName());
		comment.setBrowser(browser.getName());
	}

	private String getRequestAddress(String requestIp) {
		if (StringUtil.isBlank(requestIp)) {
			return null;
		}
		if (INetUtil.isInternalIp(requestIp)) {
			return "内网IP";
		}
		return searcher.getAddress(requestIp);
	}

	private LambdaQueryWrapper<Comment> buildQueryWrapper(CommentCriteria criteria) {
		return Wrappers.<Comment>lambdaQuery()
			.eq(Objects.nonNull(criteria.getCommentType()), Comment::getCommentType, criteria.getCommentType())
			.eq(Comment::getReview, LibreConstants.YES)
			.eq(Objects.nonNull(criteria.getUserId()), Comment::getUserId, criteria.getUserId())
			.eq(Objects.nonNull(criteria.getParentId()), Comment::getParentId, criteria.getParentId())
			.in(CollectionUtils.isNotEmpty(criteria.getIds()), Comment::getId, criteria.getIds())
			.in(CollectionUtils.isNotEmpty(criteria.getParentIds()), Comment::getParentId, criteria.getParentIds())
			.orderByDesc(Comment::getGmtCreate)
			.last(Objects.nonNull(criteria.getLimit()), "limit " + criteria.getLimit());
	}

}
