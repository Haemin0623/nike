package com.ch.nike.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Wish;



@Mapper
public interface WishMapper {

	List<Wish> wishselect(String email);



}
