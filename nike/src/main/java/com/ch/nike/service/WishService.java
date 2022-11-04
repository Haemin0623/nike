package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.Wish;

public interface WishService {
	List<Wish> wishselect(String email);
	List<Wish> selectWish(String email);
	Product selectWishThum(int productNo);
	Wish selectWishResult(String email, int productNo);
	void deleteWish(String email, int productNo);
	int selectCount();
	void addWish(String email, int productNo, int wishNo);
}
