package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mm;

	// MemberCon
	public Member select(String email) {
		return mm.select(email);
	}
	public int insert(Member member) {
		return mm.insert(member);
	}
	public int changePw(Member member) {
		return mm.changePw(member);
	}
	
	// AccountCon
	public int deleteMember(String email) {
		return mm.deleteMember(email);
	}
	public int updateProfile(Member member) {
		return mm.updateProfile(member);
	}

	
	// AdminCon
	public List<Member> paginglist(PagingBean pagingbean) {
		return mm.paginglist(pagingbean);
	}
	public int getTotal(PagingBean pagingbean) {
		return mm.getTotal(pagingbean);
	}

	@Override
	public int kakaoinsert(Member member) {
		return mm.kakaoinsert(member);
	}
	@Override
	public Member kakaoselect(Member member) {
		return mm.kakaoselect(member);
	}
	
	
	// NikeLogin
	public int insertByNaver(Member member) {
		return mm.insertByNaver(member);

	}

	

}
