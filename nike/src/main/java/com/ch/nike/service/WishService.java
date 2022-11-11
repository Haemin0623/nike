package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Wish;

public interface WishService {

	// WishCon
	Wish selectByEmail(Wish wish);
	int insert(Wish wish);
	void delete(int wishNo);
	
	
	// AccountCon
	// 회원의 위시리스트 전체
	List<Wish> wishList(String email);
	List<Wish> wishselect(String email);
}
