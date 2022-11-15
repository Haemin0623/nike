package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Cart;

@Mapper
public interface CartMapper {
	
	// AccountCon
	List<Cart> cartList(String email);
	Cart select(Cart cart);
	int insert(Cart cart);
	int update(Cart cart2);
	int deleteCart(int cartNo);
	Cart selectBy(int cartNo);
	void updateQuantity(Cart cart);
	void updateSize(Cart cart);
	
	
	// UserOrderCon
	int totalPriceByEmail(String email);
	void deleteAfterOrder(String email);


}
