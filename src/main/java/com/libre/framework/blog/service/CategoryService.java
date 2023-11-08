package com.libre.framework.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.dto.CategoryCriteria;
import com.libre.framework.blog.pojo.dto.CategoryDTO;

import java.util.List;

public interface CategoryService extends IService<Category> {

    PageDTO<Category> findByPage(PageDTO<Category> page, CategoryCriteria criteria);

    void add(CategoryDTO category);

    void edit(CategoryDTO category);

    List<Category> findList(CategoryCriteria criteria);
}
