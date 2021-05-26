package com.todo.app.mvc.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.mvc.repository.SchedulerRepository;

@Service
public class SchedulerServiceImpl implements SchedulerService {

//	private final SchedulerRepository schedulerRepository;
//	
//	public SchedulerServiceImpl(SchedulerRepository schedulerRepository) {
//		this.schedulerRepository = schedulerRepository;
//	}
	@Autowired
	SchedulerRepository schedulerRepository;
	
	@Override
	public void registerDayClose() {
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		schedulerRepository.registerDayClose(dtFormat.format(cal.getTime()));
	}

}
