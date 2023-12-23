package com.libre.framework.blog.service.mapstruct;

import com.libre.framework.blog.pojo.Comment;
import com.libre.framework.blog.pojo.vo.CommentVO;
import com.libre.toolkit.mapstruct.BaseMapping;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapping extends BaseMapping<Comment, CommentVO> {

	CommentMapping INSTANCE = org.mapstruct.factory.Mappers.getMapper(CommentMapping.class);

}
