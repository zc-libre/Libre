package com.libre.framework.blog.service.mapstruct;

import com.libre.framework.blog.pojo.Tag;
import com.libre.framework.blog.pojo.dto.TagDTO;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagMapping extends BaseMapping<TagDTO, Tag> {

    TagMapping INSTANCE = Mappers.getMapper(TagMapping.class);

}
