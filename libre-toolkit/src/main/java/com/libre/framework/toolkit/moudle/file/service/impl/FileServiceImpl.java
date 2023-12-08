package com.libre.framework.toolkit.moudle.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.libre.framework.toolkit.moudle.file.mapper.SysFileMapper;
import com.libre.framework.toolkit.moudle.file.pojo.SysFile;
import com.libre.framework.toolkit.moudle.file.pojo.SysFileCriteria;
import com.libre.framework.toolkit.moudle.file.service.FileService;
import com.libre.framework.toolkit.moudle.file.strategy.FileStoreFactory;
import com.libre.framework.toolkit.moudle.file.strategy.FileStoreStrategy;
import com.libre.toolkit.core.StringUtil;
import com.libre.toolkit.exception.LibreException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

/**
 * @author: Libre
 * @Date: 2023/1/27 4:11 AM
 */
@Slf4j
@Service
public class FileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements FileService {

	@Override
	public PageDTO<SysFile> findByPage(PageDTO<SysFile> page, SysFileCriteria criteria) {
		return this.page(page, getQueryWrapper(criteria));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String createFile(MultipartFile file, Integer saveType) {
		SysFile sysFile = new SysFile();
		String originalFilename = file.getOriginalFilename();
		String fileName = Clock.systemDefaultZone().millis() + StringPool.DASH + originalFilename;
		sysFile.setRealName(fileName);
		sysFile.setName(originalFilename);
		if (StringUtil.isNotBlank(originalFilename)) {
			String fileExtension = Files.getFileExtension(originalFilename);
			sysFile.setSuffix(fileExtension);
		}
		sysFile.setSize(file.getSize());
		sysFile.setSaveType(saveType);
		FileStoreStrategy fileStoreStrategy = FileStoreFactory.getFileStoreStrategy(saveType);
		String path;
		try {
			fileStoreStrategy.createFile(file, sysFile);
			this.save(sysFile);
			path = sysFile.getPath();
		}
		catch (Exception e) {
			fileStoreStrategy.delete(sysFile);
			log.info("文件上传失败", e);
			throw new LibreException("文件上传失败");
		}
		return path;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteFile(Long fileId) {
		SysFile sysFile = Optional.ofNullable(this.getById(fileId)).orElseThrow(() -> new LibreException("文件不存在"));
		FileStoreStrategy fileStoreStrategy = FileStoreFactory.getFileStoreStrategy(sysFile.getSaveType());
		fileStoreStrategy.delete(sysFile);
		baseMapper.realDeleteById(fileId);
	}

	@Override
	public String getFilePath(Long id) {
		SysFile sysFile = Optional.ofNullable(this.getById(id)).orElseThrow(() -> new LibreException("文件不存在"));
		FileStoreStrategy fileStoreStrategy = FileStoreFactory.getFileStoreStrategy(sysFile.getSaveType());
		return fileStoreStrategy.getFileUrl(sysFile);
	}

	@Async
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void sync(Integer saveType) {
		baseMapper.deleteBySaveType(saveType);
		FileStoreStrategy fileStoreStrategy = FileStoreFactory.getFileStoreStrategy(saveType);
		List<SysFile> allFiles = Lists.newArrayList();
		List<SysFile> fileList = fileStoreStrategy.getAllFiles();
		allFiles.addAll(fileList);
		this.saveBatch(allFiles);
	}

	private LambdaQueryWrapper<SysFile> getQueryWrapper(SysFileCriteria criteria) {
		return Wrappers.<SysFile>lambdaQuery()
				.nested(criteria.isBlurryQuery(), q -> q.like(SysFile::getName, criteria.getBlurry()))
				.eq(SysFile::getSaveType, criteria.getSaveType());
	}

}
