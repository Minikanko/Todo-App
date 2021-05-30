package com.todo.app.mvc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CompleteRate {
	private String regId;
	private String targetDt;
	private String completeRate;
}
