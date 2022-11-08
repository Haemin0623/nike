package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Cart;
import com.ch.nike.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper cm;
	
	public List<Cart> selectCart(String email) {
		return cm.selectCart(email);
	}
	public int getDetailNo(int productNo, String size, String color) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("productNo", productNo);
		map.put("size", size);
		map.put("color", color);
		return cm.getDetailNo(map);
	}
	public int countCartNo(String email, int productDetailNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("productDetailNo", productDetailNo);
		map.put("email", email);
		return cm.countCartNo(map);
	}
	public void updateCartQuantity(String email, int productDetailNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("productDetailNo", productDetailNo);
		cm.updateCartQuantity(map);
	}
	public int cartCount() {
		return cm.cartCount();
	}
	public void addCart(int newCartNo, String email, int productDetailNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cartNo", newCartNo);
		map.put("email", email);
		map.put("productDetailNo", productDetailNo);
		cm.addCart(map);
	}
	public void deleteCart(int cartNo) {
		cm.deleteCart(cartNo);
	}

}
