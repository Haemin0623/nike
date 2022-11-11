package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Cart;

public interface CartService {
	
	// AccountCon
	// 회원의 장바구니 전체
	List<Cart> cartList(String email);
	// 회원이 장바구니에 해당 상품을 담았는지 조회	
	Cart select(Cart cart);
	// 장바구니에 추가
	int insert(Cart cart);
	// 장바구니에 담겨있으면 재고 하나 추가
	int update(Cart cart2);
	// 장바구니에서 삭제
	int deleteCart(int cartNo);


}
