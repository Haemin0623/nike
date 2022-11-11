package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewMapper rm;
	
	// ReviewCon
	public Review productReview(String email, int productNo, String color) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("productNo", productNo);
		map.put("color", color);
		return rm.productReview(map);
	}
	public int countReview() {
		return rm.countReview();
	}
	public int insert(Review review) {
		return rm.insert(review);
	}
	public int deleteReview(int reviewNo) {
		return rm.deleteReview(reviewNo);
	}
	public Review reviewInfo(int reviewNo) {
		return rm.reviewInfo(reviewNo);
	}
	public void update(Review review) {
		rm.update(review);
	}
	
	
	
	
	// ProductCon
	public List<Review> selectProductReview(int productNo) {
		return rm.selectProductReview(productNo);
	}
	
	
	

	// AccountCon
	public List<Review> memberReview(String email) {
		return rm.memberReview(email);
	}
	
	
	
	// AdminCon
	@Override
	public List<Review> reviewselect(String email) {
		return rm.reviewselect(email);
	}
	@Override
	public int getTotal() {
		return rm.getTotal();
	}
	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return rm.paginglist(pagingbean);
	}
	
}