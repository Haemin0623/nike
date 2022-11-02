package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Member;


@Mapper
public interface MemberMapper {

	Member select(String email);
	int insert(Member member);
	List<Member> memberlist();
	int update(String email); //새비번변경

}
