package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Review;
import com.ch.nike.dto.ReviewPhoto;
import com.ch.nike.mapper.ProductMapper;
import com.ch.nike.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewMapper rm;

	@Override
	public List<Review> reviewlist() {
		return rm.reviewlist();
	}
	@Override
	public List<Review> reviewselect(String email) {
		return rm.reviewselect(email);
	}
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
	public List<Review> selectProductReview(int productNo) {
		return rm.selectProductReview(productNo);
	}
	public int deleteReview(int reviewNo) {
		return rm.deleteReview(reviewNo);
	}
	@Override
	public List<Review> memberReview(String email) {
		return rm.memberReview(email);
	}

}