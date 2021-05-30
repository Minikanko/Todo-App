package com.todo.app.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.todo.app.mvc.domain.CompleteRate;
import com.todo.app.mvc.domain.TodoList;
import com.todo.app.mvc.domain.TodoListParameter;

@Repository
public interface TodoListRepository {
	
	TodoList findTodoListBySeq(String seq);
	
	List<TodoList> getAllTodoList();
	
	List<TodoList> getAllTodoListByDay(String targetDt);
	
	CompleteRate getCompleteRateByDay(String targetDt);
	
	void registerTodoList(TodoListParameter todoListParameter);
	
	void updateTodoList(TodoListParameter todoListParameter);
	
	void updateTodoListComplete(TodoList todoList);
	
	void deleteTodoList(String seq);
}
