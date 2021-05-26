package com.todo.app.mvc.domain;

public enum BaseResponseCode {
	SUCCESS,			//성공
	ERROR, 				//실패
	DATA_IS_NULL, 		//데이터가 null	
	VALIDATE_REQUIED 	//필수값 체크
	;
}
