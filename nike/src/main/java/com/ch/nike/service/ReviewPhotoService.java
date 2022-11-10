package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.ReviewPhoto;

public interface ReviewPhotoService {

	int countReviewPhoto();

	int insert(ReviewPhoto rp);
	
	List<ReviewPhoto> selectReviewPhoto(int reviewNo);

	void delete(int reviewNo);


}
