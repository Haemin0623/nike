package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Review;

public interface ReviewService {
	List<Review> reviewlist();
	List<Review> reviewselect(String email);
	Review productReview(String email, int productNo);
	int countReview();
	int insert(Review review);
}
