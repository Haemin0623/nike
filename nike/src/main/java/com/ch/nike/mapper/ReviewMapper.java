package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Review;


@Mapper
public interface ReviewMapper {

	List<Review> reviewlist();

	List<Review> reviewselect(String email);

	Review productReview(HashMap<String, Object> map);

	int countReview();

	int insert(Review review);


}
