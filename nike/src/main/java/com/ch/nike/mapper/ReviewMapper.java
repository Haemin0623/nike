package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;

@Mapper
public interface ReviewMapper {

	// ReviewCon
	Review productReview(HashMap<String, Object> map);
	int countReview();
	int insert(Review review);
	int deleteReview(int reviewNo);
	Review reviewInfo(int reviewNo);
	void update(Review review);
		
	
	// ProductCon
	List<Review> selectProductReview(int productNo);
		
	
	// AccountCon
	List<Review> memberReview(String email);
	
	
	// AdminCon
	List<Review> reviewselect(String email);
	int getTotal();
	List<UserOrder> paginglist(PagingBean pagingbean);
	


}
