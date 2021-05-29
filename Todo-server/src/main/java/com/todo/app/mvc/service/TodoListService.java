package com.todo.app.mvc.service;

import java.util.List;
import java.util.Optional;

import com.todo.app.mvc.domain.TodoList;
import com.todo.app.mvc.domain.TodoListParameter;

public interface TodoListService {
	public TodoList findOneTodoList(String seq);
	
	public List<TodoList> getAllTodoListByDay();
	
	public void saveTodoList(TodoListParameter todoListParameter);
	
	public void updateTodoListComplete(TodoList todoList);
	
	public void deleteTodoList(String seq);
	
}
