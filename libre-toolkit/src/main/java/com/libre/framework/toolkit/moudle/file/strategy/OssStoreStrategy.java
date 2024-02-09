package com.libre.framework.toolkit.moudle.file.strategy;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.libre.framework.toolkit.moudle.file.pojo.FileSaveType;
import com.libre.framework.toolkit.moudle.file.pojo.SysFile;
import com.libre.oss.config.OssProperties;
import com.libre.oss.support.OssTemplate;
import com.libre.toolkit.core.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

/**
 * @author: Libre
 * @Date: 2023/1/8 4:43 AM
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OssStoreStrategy extends AbstractFileStoreStrategy {

	private final OssTemplate ossTemplate;

	private final OssProperties ossProperties;

	@Override
	public void createFile(MultipartFile sourceFile, SysFile destFile) throws Exception {
		String bucket = getBucket(destFile);
		ossTemplate.putObject(bucket, destFile.getRealName(), sourceFile.getInputStream());
		String filePath = ossTemplate.getObjectURL(bucket, destFile.getRealName());
		destFile.setPath(filePath);
		destFile.setSaveType(FileSaveType.OSS.getType());
	}

	@Override
	public void delete(SysFile sysFile) {
		String bucket = getBucket(sysFile);
		try {
			ossTemplate.removeObject(bucket, sysFile.getRealName());
		}
		catch (Exception e) {
			log.error("文件删除失败, fileName: {}", sysFile.getRealName(), e);
		}
	}

	@Override
	public String getFileUrl(SysFile sysFile) {
		String bucket = getBucket(sysFile);
		return ossTemplate.getObjectURL(bucket, sysFile.getRealName(), Duration.ofHours(2));
	}

	@Override
	public List<SysFile> getAllFiles() {
		List<Bucket> allBuckets = ossTemplate.getAllBuckets();
		if (CollectionUtils.isEmpty(allBuckets)) {
			return Collections.emptyList();
		}

		List<String> bucketNames = allBuckets.stream().map(Bucket::getName).toList();
		List<SysFile> sysFileList = Lists.newCopyOnWriteArrayList();
		for (String bucketName : bucketNames) {
			findAllFiles(sysFileList, bucketName);
		}
		return sysFileList;
	}

	private void findAllFiles(List<SysFile> sysFileList, String bucketName) {
		List<S3ObjectSummary> allObjects = ossTemplate.listAllObjects(bucketName);
		if (CollectionUtils.isEmpty(allObjects)) {
			return;
		}

		for (S3ObjectSummary object : allObjects) {
			SysFile sysFile = new SysFile();
			String fileName = object.getKey();
			int index = fileName.indexOf(StringPool.DASH);
			if (index > 0) {
				sysFile.setName(fileName.substring(index + 1));
			}
			else {
				sysFile.setName(fileName);
			}
			sysFile.setRealName(fileName);
			sysFile.setSize(object.getSize());
			sysFile.setSuffix(Files.getFileExtension(fileName));
			sysFile.setSaveType(FileSaveType.OSS.getType());
			sysFileList.add(sysFile);
		}
	}

	private String getBucket(SysFile file) {
		String bucket = file.getBucket();
		if (StringUtil.isBlank(bucket)) {
			bucket = ossProperties.getBucketName();
		}
		return bucket;
	}

}
