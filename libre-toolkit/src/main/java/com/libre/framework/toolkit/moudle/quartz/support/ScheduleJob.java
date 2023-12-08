package com.libre.framework.toolkit.moudle.quartz.support;

import com.libre.boot.autoconfigure.SpringContext;
import com.libre.framework.common.util.ReflectionUtil;
import com.libre.framework.toolkit.moudle.quartz.pojo.SysJob;
import com.libre.toolkit.exception.LibreException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
public class ScheduleJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		SysJob scheduleJob = (SysJob) context.getMergedJobDataMap().get(SysJob.JOB_KEY);

		Object bean = SpringContext.getBean(scheduleJob.getBeanName());

		if (Objects.isNull(bean)) {
			throw new LibreException("bean is not exist, beanName: " + scheduleJob.getBeanName());
		}
		String methodName = scheduleJob.getMethodName();
		Method method;

		String params = scheduleJob.getParams();
		try {
			if (StringUtils.isNotBlank(params)) {
				method = bean.getClass().getDeclaredMethod(methodName, String.class);
				ReflectionUtil.makeAccessible(method);
				ReflectionUtil.invokeMethod(method, bean, params);
			}
			else {
				method = bean.getClass().getDeclaredMethod(methodName);
				ReflectionUtil.makeAccessible(method);
				ReflectionUtil.invokeMethod(method, bean);
			}
		}
		catch (Exception e) {
			throw new JobExecutionException(e);
		}

	}

}
