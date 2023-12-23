package com.libre.framework.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

	List<CategoryVO> findList();

}
