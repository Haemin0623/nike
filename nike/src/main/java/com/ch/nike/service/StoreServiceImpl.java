package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.mapper.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService{
	@Autowired
	private StoreMapper sm;

	@Override
	public List<Store> storelist() {
		return sm.storelist();
	}

	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return sm.paginglist(pagingbean);
	}
}