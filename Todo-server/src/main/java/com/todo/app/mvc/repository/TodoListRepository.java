package com.todo.app.mvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.todo.app.mvc.domain.TodoList;

@Repository
public interface TodoListRepository {
	
	Optional<TodoList> findTodoListBySeq(String seq);
	
	List<TodoList> getAllTodoList();
	
	void registerTodoList(TodoList todoList);
	
	void updateTodoList(TodoList todoList);
	
	void updateTodoListComplete(TodoList todoList);
	
	void deleteTodoList(String seq);
}
