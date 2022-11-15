package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.PagingBean;

public interface MemberService {

	
	// MemberCon
	// 회원 조회 (+AccountCon +AdminCon)
	Member select(String email);
	// 회원 등록
	int insert(Member member);
	// 비번만 변경
	int changePw(Member member);
	// naver 로그인 회원등록
	int insertByNaver(Member member);
	// kakao 회원가입
	int kakaoinsert(Member member);
	//kakao 아이디 중복 조회
	Member kakaoselect(Member member);
	
	// AccountCon
	// 회원 탈퇴
	int deleteMember(String email);
	
	
	// AdminCon
	// 모든 회원 조회(페이징)
	List<Member> paginglist(PagingBean pagingbean);
	// 회원 갯수
	int getTotal(PagingBean pagingbean);
	
	//회원정보 수정
	int updateProfile(Member member);
	
	
	
}
