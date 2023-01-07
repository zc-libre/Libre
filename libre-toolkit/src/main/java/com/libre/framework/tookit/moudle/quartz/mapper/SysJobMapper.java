package com.libre.framework.tookit.moudle.quartz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.libre.framework.tookit.moudle.quartz.pojo.SysJob;
import com.libre.framework.tookit.moudle.quartz.pojo.SysJobCriteria;
import com.libre.framework.tookit.moudle.quartz.pojo.SysJobVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Libre
 * @Date: 2022/12/30 9:19 PM
 */
public interface SysJobMapper extends BaseMapper<SysJob> {

	/**
	 * 查询定时作业和触发器列表
	 * @param page 分页模型
	 * @param query 查询对象
	 * @return 定时作业和触发器列表
	 */
	IPage<SysJobVO> page(Page<SysJobVO> page, @Param("query") SysJobCriteria query);

}
