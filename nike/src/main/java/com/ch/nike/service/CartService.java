package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Cart;

public interface CartService {
	
	Cart select(Cart cart);
	int insert(Cart cart);
	int update(Cart cart2);
	List<Cart> cartList(String email);
	int deleteCart(int cartNo);

	int getDetailNo(int productNo, String size, String color);
	
	int countCartNo(String email, int productDetailNo);
	
	void updateCartQuantity(String email, int productDetailNo);
	
	int cartCount();

	void addCart(int newCartNo, String email, int productDetailNo);


}
