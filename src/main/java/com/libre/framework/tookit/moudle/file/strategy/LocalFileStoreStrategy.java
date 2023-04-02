package com.libre.framework.tookit.moudle.file.strategy;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.google.common.collect.Lists;
import com.libre.framework.common.config.LibreFileProperties;
import com.libre.framework.tookit.moudle.file.pojo.FileSaveType;
import com.libre.framework.tookit.moudle.file.pojo.SysFile;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: Libre
 * @Date: 2023/1/18 12:03 AM
 */
@Component
@RequiredArgsConstructor
public class LocalFileStoreStrategy extends AbstractFileStoreStrategy {

	private final LibreFileProperties properties;

	@Override
	public void createFile(MultipartFile sourceFile, SysFile destFile) throws Exception {
		String uploadPath = properties.getUploadPath() + destFile.getRealName();
		destFile.setPath(uploadPath);
		Files.copy(sourceFile.getInputStream(), Paths.get(destFile.getPath()));
	}

	@Override
	public void delete(SysFile sysFile) {
		FileUtils.deleteQuietly(new File(sysFile.getPath()));
	}

	@Override
	public List<SysFile> getAllFiles() {
		String uploadPath = properties.getUploadPath();
		Collection<File> files = FileUtils.listFiles(new File(uploadPath), null, true);
		List<SysFile> sysFileList = Lists.newArrayList();
		for (File file : files) {
			SysFile sysFile = new SysFile();
			String name = file.getName();
			int index = name.indexOf(StringPool.DASH);
			if (index > 0) {
				sysFile.setName(name.substring(index + 1));
			}
			else {
				sysFile.setName(name);
			}
			sysFile.setRealName(file.getName());
			sysFile.setPath(file.getAbsolutePath());
			sysFile.setSaveType(FileSaveType.LOCAL.getType());
			sysFile.setSize(file.length());
			sysFile.setSuffix(com.google.common.io.Files.getFileExtension(name));
			sysFileList.add(sysFile);
		}
		return sysFileList;
	}

}
