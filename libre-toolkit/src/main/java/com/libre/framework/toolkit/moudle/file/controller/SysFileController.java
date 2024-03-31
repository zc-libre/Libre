package com.libre.framework.toolkit.moudle.file.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.toolkit.moudle.file.pojo.SysFile;
import com.libre.framework.toolkit.moudle.file.pojo.SysFileCriteria;
import com.libre.framework.toolkit.moudle.file.service.FileService;
import com.libre.toolkit.result.R;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: Libre
 * @Date: 2023/1/18 12:08 AM
 */
@Tag(name = "文件管理", description = "文件管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sys/files")
public class SysFileController {

	private final FileService fileService;

	@PostMapping
	public R<SysFile> upload(@RequestParam("file") MultipartFile file, Integer type) throws Exception {
		SysFile sysFile = fileService.createFile(file, type);
		return R.data(sysFile);
	}

	@GetMapping
	public R<PageDTO<SysFile>> page(PageDTO<SysFile> page, SysFileCriteria criteria) {
		PageDTO<SysFile> pageDTO = fileService.findByPage(page, criteria);
		return R.data(pageDTO);
	}

	@GetMapping("/path/{id}")
	public R<String> getFilePath(@PathVariable Long id) {
		String filePath = fileService.getFilePath(id);
		return R.data(filePath);
	}

	@DeleteMapping
	public R<Boolean> delete(@RequestBody List<Long> ids) {
		for (Long id : ids) {
			fileService.deleteFile(id);
		}

		return R.status(true);
	}

	@PostMapping("sync")
	public R<Boolean> sync(Integer saveType) {
		fileService.sync(saveType);
		return R.status(true);
	}

}
