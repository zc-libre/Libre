package com.libre.framework.tookit.moudle.quartz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libre.framework.tookit.moudle.quartz.mapper.SysJobMapper;
import com.libre.framework.tookit.moudle.quartz.pojo.SysJob;
import com.libre.framework.tookit.moudle.quartz.pojo.SysJobCriteria;
import com.libre.framework.tookit.moudle.quartz.pojo.SysJobVO;
import com.libre.framework.tookit.moudle.quartz.support.ScheduleJob;
import com.libre.toolkit.exception.LibreException;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author: Libre
 * @Date: 2022/12/30 9:18 PM
 */
@Service
@RequiredArgsConstructor
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements SysJobService {

	private final Scheduler scheduler;

	private static final String JOB_NAME = "TASK_";

	@Override
	public IPage<SysJobVO> page(Page<SysJobVO> page, SysJobCriteria criteria) {
		return baseMapper.page(page, criteria);
	}

	@Override
	public void addJob(SysJob job) {
		try {
			// 构建job信息
			JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(JOB_NAME + job.getId()).build();

			// 通过触发器名和cron 表达式创建 Trigger
			Trigger cronTrigger = newTrigger().withIdentity(JOB_NAME + job.getId()).startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression())).build();

			cronTrigger.getJobDataMap().put(SysJob.JOB_KEY, job);
			// 重置启动时间
			((CronTriggerImpl) cronTrigger).setStartTime(new Date());

			// 执行定时任务
			scheduler.scheduleJob(jobDetail, cronTrigger);

		}
		catch (Exception e) {
			log.error("创建定时任务失败", e);
			throw new LibreException("创建定时任务失败");
		}
	}

	@Override
	public void deleteJob(Long jobId) {
		SysJob sysJob = baseMapper.selectById(jobId);
		try {
			scheduler.pauseTrigger(TriggerKey.triggerKey(JOB_NAME + sysJob.getId()));
			scheduler.unscheduleJob(TriggerKey.triggerKey(JOB_NAME + sysJob.getId()));
			scheduler.deleteJob(JobKey.jobKey(JOB_NAME + sysJob.getId()));
		}
		catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			throw new LibreException("任务删除失败");
		}
	}

	@Override
	public void pauseJob(SysJob sysJob) {
		try {
			scheduler.pauseJob(JobKey.jobKey(JOB_NAME + sysJob.getId()));
		}
		catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			throw new LibreException("任务暂停失败");
		}
	}

	@Override
	public void resumeJob(SysJob sysJob) {

		try {
			scheduler.resumeJob(JobKey.jobKey(JOB_NAME + sysJob.getId()));
		}
		catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			throw new LibreException("任务恢复失败");
		}
	}

	@Override
	public void cronJob(SysJob sysJob) {

		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(JOB_NAME + sysJob.getId());
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getCronExpression());
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			// 根据Cron表达式构建一个Trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		}
		catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			throw new LibreException("任务重置失败");
		}
	}

}
