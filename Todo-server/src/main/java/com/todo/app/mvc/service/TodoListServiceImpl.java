package com.todo.app.mvc.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.mvc.domain.TodoList;
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
	public Optional<TodoList> findOneTodoList(String seq) {
		return todoListRepository.findTodoListBySeq(seq);
	}
	
	public List<TodoList> getAllTodoList(String seq) {
		return todoListRepository.getAllTodoList();
	}
	
	
	public void addTodoList(TodoList todoList) {
		todoListRepository.registerTodoList(todoList);
	}
	
	public void updateTodoList(TodoList todoList) {
		todoListRepository.updateTodoList(todoList);
	}
	
	/**
	 * TodoList 완료여부 수정
	 * @param TodoList
	 * @return	
	 */
	public void updateTodoListComplete(TodoList todoList) {
		todoListRepository.updateTodoListComplete(todoList);
	}
	
	public void deleteTodoList(String seq) {
		todoListRepository.deleteTodoList(seq);
	}
}
