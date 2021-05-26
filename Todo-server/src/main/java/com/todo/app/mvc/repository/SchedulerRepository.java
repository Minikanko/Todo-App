package com.todo.app.mvc.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerRepository {
	
	/**
	 *  목적	: 성취율 일마감
	 * @param targetDt	
	 */
	void registerDayClose(String targetDt);
}
