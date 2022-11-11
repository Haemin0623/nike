package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.ReviewPhoto;
@Mapper
public interface ReviewPhotoMapper {

	// ReviewCon
	int countReviewPhoto();
	List<ReviewPhoto> selectReviewPhoto(int reviewNo);
	void delete(int reviewNo);
	int insert(ReviewPhoto rp);
	
	

	


}
