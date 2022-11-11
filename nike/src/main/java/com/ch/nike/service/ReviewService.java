package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;

public interface ReviewService {
	
	// ReviewCon
	// 회원이 한 상품에 대해 작성한 리뷰
	Review productReview(String email, int productNo, String color);
	// 리뷰테이블 최대 번호
	int countReview();
	// 리뷰테이블에 추가
	int insert(Review review);
	// 해당 리뷰 삭제
	int deleteReview(int reviewNo);
	// 번호로 리뷰 조회
	Review reviewInfo(int reviewNo);
	// 해당 리뷰 수정
	void update(Review review);
	
	
	
	// ProductCon
	// 해당 상품 리뷰 전체 조회
	List<Review> selectProductReview(int productNo);
	
	
	
	// AccountCon
	// 회원의 모든 리뷰	(삭제x 만)
	List<Review> memberReview(String email);
	
	
	
	// AdminCon
	// 회원의 모든 리뷰 (삭제 상관 x)
	List<Review> reviewselect(String email);
	// 리뷰 갯수
	int getTotal();
	// 모든 리뷰 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);	
	

}
