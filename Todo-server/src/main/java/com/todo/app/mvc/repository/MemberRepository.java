package com.todo.app.mvc.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.todo.app.mvc.domain.Member;

@Repository
public interface MemberRepository {
	Optional<Member> findMemberById(String id);
	Optional<Member> findMemberByIdAndPw(Member member);
	void registerMember(Member member);
}
