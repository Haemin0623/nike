package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrderDetail;

public interface UserOrderDetailService {

	// AdminCon
	// 주문 상세 갯수
	int getTotal(PagingBean pagingbean);
	// 주문 상세 전체 조회(페이징)
	List<UserOrderDetail> paginglist(PagingBean pagingbean);
	int refundchkupdate(UserOrderDetail userOrderDetail);


}
