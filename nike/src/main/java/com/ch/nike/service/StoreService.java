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
	List<Store> paginglist(PagingBean pagingbean);
	Store selectstoreno(int storeNo);
	List<Store> storelist(Store store);
	int storedelete(int storeNo);
	int adminstoreinsert(Store store);


}
