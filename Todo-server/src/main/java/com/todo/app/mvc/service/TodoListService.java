package com.todo.app.mvc.service;

import java.util.List;
import java.util.Optional;

import com.todo.app.mvc.domain.TodoList;

public interface TodoListService {
	public Optional<TodoList> findOneTodoList(String seq);
	
	public List<TodoList> getAllTodoList(String seq);
	
	public void addTodoList(TodoList todoList);
	
	public void updateTodoList(TodoList todoList);
	
	public void updateTodoListComplete(TodoList todoList);
	
	public void deleteTodoList(String seq);
	
}
