package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;

public interface CartService {
	
	Cart select(Cart cart);
	int insert(Cart cart);
	int update(Cart cart2);
	List<Cart> cartList(String email);
	int deleteCart(int cartNo);


}
