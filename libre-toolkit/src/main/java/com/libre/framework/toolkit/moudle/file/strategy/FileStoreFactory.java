package com.libre.framework.toolkit.moudle.file.strategy;

import com.google.common.collect.Lists;
import com.libre.boot.autoconfigure.SpringContext;
import com.libre.framework.toolkit.moudle.file.pojo.FileSaveType;
import lombok.experimental.UtilityClass;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @author: Libre
 * @Date: 2023/1/27 3:48 AM
 */
@UtilityClass
public class FileStoreFactory {

	@SuppressWarnings("unchecked")
	public static <T extends FileStoreStrategy> T getFileStoreStrategy(Integer type) {
		if (FileSaveType.OSS.getType().equals(type)) {
			return (T) SpringContext.getBean(OssStoreStrategy.class);
		}
		else {
			return (T) SpringContext.getBean(LocalFileStoreStrategy.class);
		}
	}

	public static List<FileStoreStrategy> getAllStrategy() {
		ApplicationContext applicationContext = SpringContext.getContext();
		Assert.notNull(applicationContext, "applicationContext must not be null");
		Map<String, FileStoreStrategy> map = applicationContext.getBeansOfType(FileStoreStrategy.class);
		return Lists.newArrayList(map.values());
	}

}
