package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Member;
import com.ch.nike.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mm;

	@Override
	public Member select(String email) {
		return mm.select(email);
	}

	@Override
	public int insert(Member member) {
		return mm.insert(member);
	}
	@Override
	public List<Member> memberlist() {
		return mm.memberlist();
	}
}
