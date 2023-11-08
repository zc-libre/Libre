package com.libre.framework.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.blog.pojo.Tag;
import com.libre.framework.blog.pojo.dto.TagCriteria;
import com.libre.framework.blog.pojo.dto.TagDTO;

import java.util.List;

public interface TagService extends IService<Tag> {

    void add(TagDTO tagDTO);

    void edit(TagDTO tagDTO);

    PageDTO<Tag> findByPage(PageDTO<Tag> page, TagCriteria criteria);

    List<Tag> findList(TagCriteria criteria);
}
