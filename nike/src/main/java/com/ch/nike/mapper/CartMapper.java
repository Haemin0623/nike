package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Cart;

@Mapper
public interface CartMapper {
	
	Cart select(Cart cart);
	int insert(Cart cart);
	int update(Cart cart2);
	List<Cart> cartList(String email);
	int deleteCart(int cartNo);
		

	List<Cart> selectCart(String email);

	int getDetailNo(HashMap<String, Object> map);
	
	int countCartNo(HashMap<String, Object> map);
	
	void updateCartQuantity(HashMap<String, Object> map);
	
	int cartCount();

	void addCart(HashMap<String, Object> map);



}
