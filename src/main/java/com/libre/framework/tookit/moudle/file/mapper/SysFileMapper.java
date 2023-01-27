package com.libre.framework.tookit.moudle.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libre.framework.tookit.moudle.file.pojo.SysFile;
import org.apache.ibatis.annotations.Delete;

/**
 * @author: Libre
 * @Date: 2023/1/27 3:13 AM
 */
public interface SysFileMapper extends BaseMapper<SysFile> {

	@Delete("DELETE FROM sys_file WHERE is_deleted = 0")
	void deleteAll();

	@Delete("DELETE FROM sys_file WHERE id = #{id,jdbcType=BIGINT}")
	void realDeleteById(Long id);

	@Delete("DELETE FROM sys_file WHERE save_type = #{saveType,jdbcType=INTEGER}")
	void deleteBySaveType(Integer saveType);

}
