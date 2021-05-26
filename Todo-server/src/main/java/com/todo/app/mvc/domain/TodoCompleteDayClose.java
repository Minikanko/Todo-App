package com.todo.app.mvc.domain;

import lombok.Data;

/**
 * @author  	: Mr.K
 * @Date 		: 2021. 5. 25.
 * @Version 	: 1.0
 * @Method Info : Todo 성취율 객체
 */
@Data
public class TodoCompleteDayClose {
	private String id;
	private String targetDt;
	private String completeRate;
	private String regDt;
	private String modifyDt;
}
