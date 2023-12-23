package com.libre.framework.blog.service.mapstruct;

import com.libre.framework.blog.pojo.BlogUser;
import com.libre.framework.blog.pojo.dto.Author;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogUserMapping extends BaseMapping<BlogUser, Author> {

	BlogUserMapping INSTANCE = Mappers.getMapper(BlogUserMapping.class);

}
