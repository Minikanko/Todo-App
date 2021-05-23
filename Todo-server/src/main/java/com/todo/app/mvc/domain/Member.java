package com.todo.app.mvc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="password")
public class Member {
	private String id;
	private String password;
	private String name;
	private String email;
	private String regDt;
}
