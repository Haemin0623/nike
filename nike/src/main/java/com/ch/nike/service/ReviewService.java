package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Review;

public interface ReviewService {
	List<Review> reviewlist();
	List<Review> reviewselect(String email);
}
