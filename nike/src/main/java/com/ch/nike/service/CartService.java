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
	// cart 가져오기
	Cart selectBy(int cartNo);
	// 장바구니에서 수량 변경
	void updateQuantity(Cart cart);
	// 장바구니에서 사이즈 변경
	void updateSize(Cart cart);
	
	
	
	// UserOrderCon
	// 카트리스트에 담긴 물품 총 가격
	int totalPriceByEmail(String email);
	// 결제완료 후 카트리스트 삭제
	void deleteAfterOrder(String email);


}
