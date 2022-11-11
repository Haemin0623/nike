package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrder;

public interface UserOrderService {
	
	// AccountCon
	// 회원의 주문내역 전체
	List<UserOrder> selectUserOrder(String email);
	// 해당 주문의 상세정보
	UserOrder selectOrderDetail(int orderNo);
	
	

	// AdminCon
	// 회원의 주문 + 주문상세 전체
	List<UserOrder> userorderselect(String email);
	// 주문 갯수
	int getTotal();
	// 전체 주문 정보 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);
	

}
