package com.libre.framework.common.base;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.blog.pojo.Category;
import com.libre.framework.blog.pojo.dto.CategoryCriteria;
import org.checkerframework.checker.units.qual.C;

import java.util.function.Consumer;

public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

}
