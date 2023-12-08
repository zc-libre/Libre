package com.libre.framework.toolkit.moudle.file.strategy;

import com.libre.framework.toolkit.moudle.file.pojo.SysFile;

/**
 * @author: Libre
 * @Date: 2023/1/27 5:39 AM
 */
public abstract class AbstractFileStoreStrategy implements FileStoreStrategy {

	@Override
	public String getFileUrl(SysFile sysFile) {
		return sysFile.getPath();
	}

}
