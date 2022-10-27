package com.ch.nike.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Member;


@Mapper
public interface MemberMapper {

	Member select(String email);

}
