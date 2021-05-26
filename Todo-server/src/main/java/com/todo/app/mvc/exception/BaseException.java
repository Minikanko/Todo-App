package com.todo.app.mvc.exception;

import com.todo.app.mvc.domain.BaseResponseCode;

public class BaseException extends AbstractBaseException{
	
	private static final long serialVersionUID = 7159529163660247413L;
	
	public BaseException() {
	}
	
	public BaseException(BaseResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public BaseException(BaseResponseCode responseCode, String[] args) {
		this.responseCode = responseCode;
		this.args = args;
		
	}
	
	
}
