package com.libre.framework.toolkit.moudle.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.toolkit.moudle.file.mapper.SysFileMapper;
import com.libre.framework.toolkit.moudle.file.pojo.SysFile;
import com.libre.framework.toolkit.moudle.file.pojo.SysFileCriteria;
import com.libre.framework.toolkit.moudle.file.service.FileService;
import com.libre.framework.toolkit.moudle.file.strategy.FileStoreFactory;
import com.libre.framework.toolkit.moudle.file.strategy.FileStoreStrategy;
import com.libre.toolkit.core.StringUtil;
import com.libre.toolkit.exception.LibreException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
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
	public SysFile createFile(MultipartFile file, Integer saveType) throws Exception {
		SysFile sysFile = new SysFile();
		String originalFilename = file.getOriginalFilename();
		String fileName = Clock.systemDefaultZone().millis() + StringPool.DASH + originalFilename;
		sysFile.setRealName(fileName);
		sysFile.setName(originalFilename);
		if (StringUtil.isNotBlank(originalFilename)) {
			String extension = FilenameUtils.getExtension(originalFilename);
			sysFile.setSuffix(extension);
		}
		sysFile.setSize(file.getSize());
		sysFile.setSaveType(saveType);
		FileStoreStrategy fileStoreStrategy = FileStoreFactory.getFileStoreStrategy(saveType);
		fileStoreStrategy.createFile(file, sysFile);
		this.save(sysFile);
		return sysFile;
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
		FileStoreStrategy fileStoreStrategy = FileStoreFactory.getFileStoreStrategy(saveType);
		baseMapper.deleteBySaveType(saveType);
		List<SysFile> fileList = fileStoreStrategy.getAllFiles();

		if (CollectionUtils.isNotEmpty(fileList)) {
			this.saveBatch(fileList);
		}
	}

	private LambdaQueryWrapper<SysFile> getQueryWrapper(SysFileCriteria criteria) {
		return Wrappers.<SysFile>lambdaQuery()
			.nested(criteria.isBlurryQuery(), q -> q.like(SysFile::getName, criteria.getBlurry()))
			.eq(SysFile::getSaveType, criteria.getSaveType());
	}

}
