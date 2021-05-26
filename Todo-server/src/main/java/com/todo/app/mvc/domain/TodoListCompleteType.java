package com.todo.app.mvc.domain;

import lombok.Getter;

/**
 * @author  	: Mr.K
 * @Date 		: 2021. 5. 23.
 * @Version 	: 1.0
 * @Method Info : TodoList 완료여부 enum
 */
public enum TodoListCompleteType implements BaseCodeLabelEnum{
	
	Y("COMPLETE"), N("NOTCOMPLETE");
	
	private String code;
	private String label;
	
	TodoListCompleteType(String label) {
		this.code = name();
		this.label = label;
	}

	@Override
	public String code() {
		return this.code;
	}

	@Override
	public String label() {
		return this.label;
	}
	
}
