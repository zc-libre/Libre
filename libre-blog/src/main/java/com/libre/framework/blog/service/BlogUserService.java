package com.libre.framework.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.blog.pojo.BlogUser;
import com.libre.framework.blog.pojo.dto.Author;
import com.libre.framework.blog.pojo.dto.BlogUserCriteria;

import java.util.List;

public interface BlogUserService extends IService<BlogUser> {

	Author getBlogAuthor(String authorKey);

	List<BlogUser> findCriteria(BlogUserCriteria criteria);

}
