package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.ReviewPhoto;
@Mapper
public interface ReviewPhotoMapper {

	int countReviewPhoto();

	int insert(ReviewPhoto rp);
	
	List<ReviewPhoto> selectReviewPhoto(int reviewNo);

	void delete(int reviewNo);

}
