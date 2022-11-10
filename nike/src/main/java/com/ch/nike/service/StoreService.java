package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;

public interface StoreService {
	List<Store> storelist();

	List<UserOrder> paginglist(PagingBean pagingbean);

	int getTotal();
}
