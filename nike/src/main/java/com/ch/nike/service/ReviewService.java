package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Review;
import com.ch.nike.dto.ReviewPhoto;

public interface ReviewService {
	List<Review> reviewlist();
	List<Review> reviewselect(String email);
	Review productReview(String email, int productNo, String color);
	int countReview();
	int insert(Review review);
	List<Review> selectProductReview(int productNo);
	int deleteReview(int reviewNo);
	List<Review> memberReview(String email);
}
