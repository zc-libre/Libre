package com.libre.framework.tookit.moudle.file.strategy;

import com.libre.framework.tookit.moudle.file.pojo.SysFile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
