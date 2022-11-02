package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Member;

public interface MemberService {

	Member select(String email);
	int insert(Member member);
	List<Member> memberlist();
	int update(Member member); //새비번변경
}
