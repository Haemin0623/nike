package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.ReviewPhoto;
import com.ch.nike.mapper.ReviewPhotoMapper;

@Service
public class ReviewPhotoServiceImpl implements ReviewPhotoService {
	@Autowired
	private ReviewPhotoMapper ppm;

	public int countReviewPhoto() {
		return ppm.countReviewPhoto();
	}

	public int insert(ReviewPhoto rp) {
		return ppm.insert(rp);
	}
}
