package com.todo.app.mvc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoList {
	private String seq;
	private String context;
	private String targetDt;
	private String regDt;
	private String regId;
	private TodoListCompleteType isComplete;
	private String modifyDt;
}
