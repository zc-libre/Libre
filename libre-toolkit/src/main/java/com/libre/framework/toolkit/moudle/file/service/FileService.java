package com.libre.framework.toolkit.moudle.file.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libre.framework.toolkit.moudle.file.pojo.SysFile;
import com.libre.framework.toolkit.moudle.file.pojo.SysFileCriteria;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: Libre
 * @Date: 2023/1/27 4:09 AM
 */
public interface FileService extends IService<SysFile> {

	/**
	 * 分页查询
	 * @param page {@link PageDTO}
	 * @param criteria {@link SysFileCriteria}
	 * @return {@link PageDTO}
	 */
	PageDTO<SysFile> findByPage(PageDTO<SysFile> page, SysFileCriteria criteria);

	/**
	 * 存储文件
	 * @param file {@link MultipartFile}
	 * @param saveType 保存类型
	 * @return 文件连接
	 * @throws Exception e
	 */
	String createFile(MultipartFile file, Integer saveType) throws Exception;

	/**
	 * 获取文件外链
	 * @param id 文件id
	 * @return 文件连接
	 */
	String getFilePath(Long id);

	/**
	 * 删除文件
	 * @param fileId 文件id
	 */
	void deleteFile(Long fileId);

	/**
	 * oss文件同步
	 * @param saveType 保存类型
	 */
	void sync(Integer saveType);

}
