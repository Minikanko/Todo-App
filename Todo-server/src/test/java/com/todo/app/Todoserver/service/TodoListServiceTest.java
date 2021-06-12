package com.todo.app.Todoserver.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todo.app.mvc.domain.TodoList;
import com.todo.app.mvc.domain.TodoListParameter;
import com.todo.app.mvc.service.TodoListService;

@SpringBootTest
@WebAppConfiguration
public class TodoListServiceTest {
	
	@Autowired
	TodoListService todoServiceImpl;
	
	TodoListParameter todo;
	
	@BeforeEach
    public void init() {
		todo = new TodoListParameter();
		todo.setContext("test");
		todo.setTargetDt("2021-05-22");
		todo.setRegId("user1");
    }
	
	@Test
	void todo등록하기() {
		todoServiceImpl.saveTodoList(todo);
		TodoList result = todoServiceImpl.findOneTodoList(todo.getSeq());
		assertEquals(todo.getContext(), result.getContext());
	}
	
	@Test
	void todo수정하기() {
		todo.setContext("test수정");
		
		todoServiceImpl.saveTodoList(todo);
		
		TodoList result = todoServiceImpl.findOneTodoList(todo.getSeq());
		assertEquals(todo.getContext(), result.getContext());
	}
	
	@Test
	void todo삭제하기() {
		todoServiceImpl.deleteTodoList(todo.getSeq());
		
		TodoList result = todoServiceImpl.findOneTodoList(todo.getSeq());
		assertNull(result);
		
	}
}
