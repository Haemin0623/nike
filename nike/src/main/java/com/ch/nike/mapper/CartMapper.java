package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Cart;

@Mapper
public interface CartMapper {
	
	List<Cart> selectCart(String email);

	int getDetailNo(HashMap<String, Object> map);
	
	int countCartNo(HashMap<String, Object> map);
	
	void updateCartQuantity(HashMap<String, Object> map);
	
	int cartCount();

	void addCart(HashMap<String, Object> map);



}
