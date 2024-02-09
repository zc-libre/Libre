package com.libre.framework.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.blog.pojo.Comment;
import com.libre.framework.blog.pojo.dto.CommentCriteria;
import com.libre.framework.blog.pojo.dto.CommentDTO;
import com.libre.framework.blog.pojo.vo.CommentPage;
import com.libre.framework.blog.pojo.vo.CommentVO;

import java.util.List;

public interface CommentService extends IService<Comment> {

	List<CommentVO> findRecentComments();

	Long add(CommentDTO comment);

	CommentPage findByPage(PageDTO<Comment> page, CommentCriteria criteria);

}
