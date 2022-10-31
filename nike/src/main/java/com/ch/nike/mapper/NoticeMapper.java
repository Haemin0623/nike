package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Notice;


@Mapper
public interface NoticeMapper {

	List<Notice> noticelist();


}
