package com.todo.app.Todoserver.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todo.app.mvc.domain.TodoList;
import com.todo.app.mvc.domain.TodoListCompleteType;
import com.todo.app.mvc.service.TodoListService;

@SpringBootTest
@WebAppConfiguration
public class TodoListServiceTest {
	
	@Autowired
	TodoListService todoServiceImpl;
	
	TodoList todo;
	
	@BeforeEach
    public void init() {
		todo = new TodoList();
		todo.setContext("test");
		todo.setTargetDt("2021-05-22");
		todo.setRegId("user1");
		todo.setIsComplete(TodoListCompleteType.NOTCOMPLETE);
    }
	
	@Test
	void todo등록하기() {
		todoServiceImpl.addTodoList(todo);
		TodoList result = todoServiceImpl.findOneTodoList(todo.getSeq()).get();
		assertEquals(todo.getContext(), result.getContext());
	}
	
	@Test
	void todo수정하기() {
		todo.setContext("test수정");
		
		todoServiceImpl.updateTodoList(todo);
		
		TodoList result = todoServiceImpl.findOneTodoList(todo.getSeq()).get();
		assertEquals(todo.getContext(), result.getContext());
	}
	
	@Test
	void todo삭제하기() {
		todoServiceImpl.deleteTodoList(todo.getSeq());
		
		Optional<TodoList> result = todoServiceImpl.findOneTodoList(todo.getSeq());
		assertEquals(result.isPresent(), false);
		
	}
}
