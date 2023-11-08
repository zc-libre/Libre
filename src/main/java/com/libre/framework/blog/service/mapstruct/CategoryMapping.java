package com.libre.framework.blog.service.mapstruct;

import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.dto.CategoryDTO;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapping extends BaseMapping<CategoryDTO, Category> {
    CategoryMapping INSTANCE = Mappers.getMapper(CategoryMapping.class);

}
