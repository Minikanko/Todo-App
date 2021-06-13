package com.todo.app.mvc.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.mvc.domain.CompleteRate;
import com.todo.app.mvc.domain.TodoList;
import com.todo.app.mvc.domain.TodoListParameter;
import com.todo.app.mvc.repository.TodoListRepository;

@Service
public class TodoListServiceImpl implements TodoListService {
	
	@Autowired
	TodoListRepository todoListRepository;
	
	/**
	 * TodoList 상세보기
	 * @param seq
	 * @return	
	 */
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public TodoList findOneTodoList(String seq) {
		return todoListRepository.findTodoListBySeq(seq);
	}
	
	@Override
	public List<TodoList> getAllTodoListByDay() {
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		return todoListRepository.getAllTodoListByDay(dtFormat.format(cal.getTime()));
	}
	
	
	@Override
	public void saveTodoList(TodoListParameter todoListParameter) {
		logger.debug("string:{}",todoListParameter.getSeq());
		if(StringUtils.isBlank(todoListParameter.getSeq())) {
			todoListRepository.registerTodoList(todoListParameter);
		}
		else {
			todoListRepository.updateTodoList(todoListParameter);
		}
	}
	
	/**
	 * TodoList 완료여부 수정
	 * @param TodoList
	 * @return	
	 */
	@Override
	public void updateTodoListComplete(TodoList todoList) {
		todoListRepository.updateTodoListComplete(todoList);
	}
	
	@Override
	public void deleteTodoList(String seq) {
		todoListRepository.deleteTodoList(seq);
	}
	
	@Override
	public CompleteRate getCompleteRate(String targetDt) {
		return todoListRepository.getCompleteRateByDay(targetDt);
	}

}
