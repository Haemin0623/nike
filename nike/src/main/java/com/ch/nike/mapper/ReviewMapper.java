package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Review;


@Mapper
public interface ReviewMapper {

	List<Review> reviewlist();

	List<Review> reviewselect(String email);


}
