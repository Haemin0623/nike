package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Review;
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
}