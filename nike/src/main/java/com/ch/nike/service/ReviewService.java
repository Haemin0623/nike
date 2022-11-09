package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;

public interface ReviewService {
	List<Review> reviewlist();
	List<Review> reviewselect(String email);
	List<UserOrder> paginglist(PagingBean pagingbean);
	int getTotal();
}
