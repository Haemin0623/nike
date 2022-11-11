package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.ReviewPhoto;

public interface ReviewPhotoService {

	// ReviewCon
	// 리뷰 사진 테이블 최대 번호
	int countReviewPhoto();
	// 해당 리뷰 사진 전부 조회	(+ProductCon)
	List<ReviewPhoto> selectReviewPhoto(int reviewNo);
	// 해당 리뷰 사진전부 삭제
	void delete(int reviewNo);
	// 리뷰 사진 등록
	int insert(ReviewPhoto rp);
	
	

	



}
