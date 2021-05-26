package com.todo.app.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public Optional<TodoList> findOneTodoList(String seq) {
		return todoListRepository.findTodoListBySeq(seq);
	}
	
	@Override
	public List<TodoList> getAllTodoList() {
		return todoListRepository.getAllTodoList();
	}
	
	@Override
	public void saveTodoList(TodoListParameter todoListParameter) {
		if(todoListParameter.getSeq().isEmpty()) {
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


}
