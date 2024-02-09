package com.libre.framework.toolkit.moudle.file.strategy;

import com.libre.framework.toolkit.moudle.file.pojo.SysFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: Libre
 * @Date: 2022/12/30 8:43 PM
 */
public interface FileStoreStrategy {

	/**
	 * 保存文件
	 * @param sourceFile 文件
	 * @param sysFile 文件实体
	 * @throws Exception e
	 */
	void createFile(MultipartFile sourceFile, SysFile sysFile) throws Exception;

	/**
	 * 删除文件
	 * @param sysFile 文件
	 */
	void delete(SysFile sysFile);

	/**
	 * 获取文件地址
	 * @param sysFile 文件
	 * @return 文件外链
	 */
	String getFileUrl(SysFile sysFile);

	/**
	 * 获取所有文件
	 * @return 文件列表
	 */
	List<SysFile> getAllFiles();

}
