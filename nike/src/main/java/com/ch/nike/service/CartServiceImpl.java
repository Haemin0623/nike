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

	public Cart select(Cart cart) {
		return cm.select(cart);
	}

	public int insert(Cart cart) {
		return cm.insert(cart);
	}

	public int update(Cart cart2) {
		return cm.update(cart2);
	}
}
