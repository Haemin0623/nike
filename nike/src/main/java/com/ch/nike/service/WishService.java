package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.Wish;

public interface WishService {
	List<Wish> wishselect(String email);
	List<Wish> selectWish(String email);
	Product selectWishThum(int productNo, String color);
	Wish selectWishResult(String email, int productNo, String color);
	void deleteWish(String email, int productNo, String color);
	int wishCount();
	void addWish(Wish newWish);
}
