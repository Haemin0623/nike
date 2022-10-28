package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Member;

@Mapper
public interface AdminMapper {

	List<Member> memberlist();

}
