package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.QnA;


@Mapper
public interface QnAMapper {

	List<QnA> qnalist();


}
