package com.libre.framework.common.configuration;

import com.libre.toolkit.core.StringUtil;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author: Libre
 * @Date: 2023/1/27 1:56 AM
 */
@Data
@ConfigurationProperties("libre.file")
public class LibreFileProperties implements InitializingBean {

	private String uploadPath;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (StringUtil.isNotBlank(uploadPath) && !Files.exists(Paths.get(uploadPath))) {
			Files.createDirectory(Paths.get(uploadPath));
		}
	}

}
