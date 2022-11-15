package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrder;

public interface UserOrderService {
	
	// AccountCon
	// 회원의 주문내역 전체
	List<UserOrder> selectUserOrder(String email);
	// 해당 주문의 상세정보
	List<UserOrder> selectOrderDetail(int orderNo);
	// 해당 주문 상세번호에 대한 모든 정보
	UserOrder orderInfoAll(int orderDetailNo);
	// 날짜
	List<UserOrder> selectDate(String email);


	// AdminCon
	// 회원의 주문 + 주문상세 전체
	List<UserOrder> userorderselect(String email);
	// 주문 갯수
	int getTotal(PagingBean pagingbean);
	// 전체 주문 정보 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);
	List<UserOrder> paginglistrefundchk(PagingBean pagingbean);
	
	// UserOrderCon
	int currentCount();
	void insert(UserOrder userOrder);
	
	
	

}
