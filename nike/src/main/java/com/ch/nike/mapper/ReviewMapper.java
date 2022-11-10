package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;

@Mapper
public interface ReviewMapper {

	List<Review> reviewlist();

	List<Review> reviewselect(String email);


	Review productReview(HashMap<String, Object> map);

	int countReview();

	int insert(Review review);

	List<Review> selectProductReview(int productNo);

	int deleteReview(int reviewNo);

	List<Review> memberReview(String email);

	Review reviewInfo(int reviewNo);

	void update(Review review);

	

	List<UserOrder> paginglist(PagingBean pagingbean);

	int getTotal();


}
