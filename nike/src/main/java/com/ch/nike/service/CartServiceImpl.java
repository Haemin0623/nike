package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper cm;



	public List<Cart> selectCart(String email) {
		return cm.selectCart(email);
	}

	public List<Cart> cartList(String email) {
		return cm.cartList(email);
	}

	public int deleteCart(int cartNo) {
		return cm.deleteCart(cartNo);
	}


}
