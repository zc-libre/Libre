package com.libre.framework.logging.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.libre.framework.common.security.AuthUser;
import com.libre.framework.common.security.SecurityUtil;
import com.libre.framework.logging.pojo.SysLog;
import com.libre.framework.logging.pojo.SysLogCriteria;
import com.libre.framework.logging.service.SysLogService;
import com.libre.framework.logging.support.SysLogConstant;
import com.libre.toolkit.result.R;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author: Libre
 * @Date: 2022/12/17 8:10 PM
 */

@RestController
@RequestMapping("/sys/log")
@RequiredArgsConstructor
public class SysLogController {

	private final SysLogService sysLogService;

	@PostMapping("info")
	public R<PageDTO<SysLog>> pageInfo(PageDTO<SysLog> page, SysLogCriteria criteria) {
		criteria.setSuccess(SysLogConstant.SUCCESS);
		PageDTO<SysLog> result = sysLogService.findPage(page, criteria);
		return R.data(result);
	}

	@PostMapping("error")
	public R<PageDTO<SysLog>> pageError(PageDTO<SysLog> page, SysLogCriteria criteria) {
		criteria.setSuccess(SysLogConstant.FAILED);
		PageDTO<SysLog> result = sysLogService.findPage(page, criteria);
		return R.data(result);
	}

	@PostMapping("user")
	public R<PageDTO<SysLog>> queryUserLog(PageDTO<SysLog> page, SysLogCriteria criteria) {
		AuthUser user = SecurityUtil.getUser();
		Optional.ofNullable(user).ifPresent(authUser -> criteria.setUserId(user.getUserId()));
		PageDTO<SysLog> result = sysLogService.findPage(page, criteria);
		return R.data(result);
	}

	@GetMapping("error/{id}")
	@Operation(summary = "日志异常详情查询")
	public R<SysLog> queryErrorLogs(@PathVariable Long id) {
		SysLog sysLog = sysLogService.getById(id);
		return R.data(sysLog);
	}

}
