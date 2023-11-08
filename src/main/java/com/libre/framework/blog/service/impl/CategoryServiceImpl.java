package com.libre.framework.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.blog.mapper.CategoryMapper;
import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.dto.CategoryCriteria;
import com.libre.framework.blog.pojo.dto.CategoryDTO;
import com.libre.framework.blog.service.CategoryService;
import com.libre.framework.blog.service.mapstruct.CategoryMapping;
import com.libre.framework.system.pojo.entity.SysUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public PageDTO<Category> findByPage(PageDTO<Category> page, CategoryCriteria criteria) {
        return this.page(page, buildQueryWrapper(criteria));
    }

    @Override
    public void add(CategoryDTO categoryDTO) {
        CategoryMapping mapping = CategoryMapping.INSTANCE;
        Category category = mapping.sourceToTarget(categoryDTO);
        this.save(category);
    }

    @Override
    public void edit(CategoryDTO categoryDTO) {
        CategoryMapping mapping = CategoryMapping.INSTANCE;
        Category category = mapping.sourceToTarget(categoryDTO);
        this.updateById(category);
    }

    @Override
    public List<Category> findList(CategoryCriteria criteria) {
        return this.list(buildQueryWrapper(criteria));
    }

    private static LambdaQueryWrapper<Category> buildQueryWrapper(CategoryCriteria criteria) {
        LambdaQueryWrapper<Category> wrapper = Wrappers.<Category>lambdaQuery()
                .nested(criteria.isBlurryQuery(), k -> k.like(Category::getCategoryName, criteria.getBlurry()));
        if (criteria.haveTime()) {
            wrapper.between(Category::getGmtCreate, criteria.getStartTime(), criteria.getEndTime());
        }
        return wrapper;
    }
}
