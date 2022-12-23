package com.libre.framework.system.module.system.controller;

import com.google.common.collect.Maps;
import com.libre.monitor.*;
import com.libre.toolkit.result.R;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oshi.hardware.ComputerSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Libre
 * @Date: 2022/12/18 7:37 PM
 */

@RequestMapping("/monitor")
@RestController
@RequiredArgsConstructor
public class MonitorController {

	private final OshiMonitor oshiMonitor;

	@GetMapping("/server")
	public R<Map<String, Object>> server() {

		CpuInfo cpuInfo = oshiMonitor.getCpuInfo();
		List<DiskInfo> diskInfos = oshiMonitor.getDiskInfos();
		JvmInfo jvmInfo = oshiMonitor.getJvmInfo();
		MemoryInfo memoryInfo = oshiMonitor.getMemoryInfo();
		SysInfo sysInfo = oshiMonitor.getSysInfo();
		NetIoInfo netIoInfo = oshiMonitor.getNetIoInfo();

		HashMap<String, Object> map = Maps.newHashMap();
		map.put("cpuInfo", cpuInfo);
		map.put("diskInfos", diskInfos);
		map.put("memoryInfo", memoryInfo);
		map.put("sysInfo", sysInfo);
		map.put("jvmInfo", jvmInfo);
		map.put("netIoInfo", netIoInfo);
		return R.data(map);
	}

}
