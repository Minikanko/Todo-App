package com.todo.app.mvc.exception;

import com.todo.app.mvc.domain.BaseResponseCode;

import lombok.Getter;
import lombok.NoArgsConstructor;

abstract class AbstractBaseException extends RuntimeException{

	private static final long serialVersionUID = -5713664419249108931L;
	protected BaseResponseCode responseCode;
	protected Object[] args;
	
	
	
}
