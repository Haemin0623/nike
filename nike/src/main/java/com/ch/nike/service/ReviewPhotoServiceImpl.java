package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.ReviewPhoto;
import com.ch.nike.mapper.ReviewPhotoMapper;

@Service
public class ReviewPhotoServiceImpl implements ReviewPhotoService {
	@Autowired
	private ReviewPhotoMapper rpm;

	// ReviewCon
	public int countReviewPhoto() {
		return rpm.countReviewPhoto();
	}
	
	
	

	public int insert(ReviewPhoto rp) {
		return rpm.insert(rp);
	}
	public List<ReviewPhoto> selectReviewPhoto(int reviewNo) {
		return rpm.selectReviewPhoto(reviewNo);
	}
	public void delete(int reviewNo) {
		rpm.delete(reviewNo);
	}
}
