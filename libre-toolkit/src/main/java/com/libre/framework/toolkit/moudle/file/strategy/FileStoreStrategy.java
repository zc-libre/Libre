package com.libre.framework.toolkit.moudle.file.strategy;

import com.libre.framework.toolkit.moudle.file.pojo.SysFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: Libre
 * @Date: 2022/12/30 8:43 PM
 */
public interface FileStoreStrategy {

	void createFile(MultipartFile sourceFile, SysFile sysFile) throws Exception;

	void delete(SysFile sysFile);

	String getFileUrl(SysFile sysFile);

	List<SysFile> getAllFiles();

}
