package com.todo.app.mvc.domain;

import lombok.Getter;

@Getter
public class BaseResponse<T> {
	private BaseResponseCode code;
	private String message;
	private T data;	
	
	//성공했을때
	public BaseResponse(T data){
		this.code = BaseResponseCode.SUCCESS;
		this.data = data;
	}

	//실패했을때
	public BaseResponse(BaseResponseCode code, String message) {
		this.message = message;
		this.code = code;
	}
	
}
