package com.todo.app.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoListParameter {
	private String seq;
	private String context;
	private String targetDt;
	private String regId;
}
