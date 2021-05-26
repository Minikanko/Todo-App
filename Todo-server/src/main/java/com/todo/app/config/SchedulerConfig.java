package com.todo.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.todo.app.mvc.service.SchedulerService;

/**
 * @author  	: Mr.K
 * @Date 		: 2021. 5. 25.
 * @Version 	: 1.0
 * @Method Info : Scheduler 관리클래스
 */

@Component
public class SchedulerConfig {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final SchedulerService schedulerService;
	
	public SchedulerConfig(SchedulerService schedulerService) {
		super();
		this.schedulerService = schedulerService;
	}

	@Scheduled(cron = "* * 05 * * *")
	public void todoCompleteDayClose() {
		logger.debug("Todo 일마감 스케쥴러 실행 :{}",getClass());
		schedulerService.registerDayClose();
	}
}
