package com.todo.app.mvc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author  	: Mr.K
 * @Date 		: 2021. 5. 25.
 * @Version 	: 1.0
 * @Method Info : API 등록/수정 전용 클래스
 */
@Getter
@Setter
@ToString
public class TodoListParameter {
	private String seq;
	private String context;
	private String targetDt;
	private String regId;
}
