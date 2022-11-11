package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;

public interface StoreService {
	
	// AdminCon
	// 매장 정보 갯수
	int getTotal();
	// 매장 전체 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);


}
