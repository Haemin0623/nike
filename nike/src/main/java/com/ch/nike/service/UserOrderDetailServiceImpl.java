package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrderDetail;
import com.ch.nike.mapper.UserOrderDetailMapper;

@Service
public class UserOrderDetailServiceImpl implements UserOrderDetailService {
	@Autowired
	private UserOrderDetailMapper uodm;

	
	// AdminCon
	@Override
	public int getTotal() {
		return uodm.getTotal();
	}
	@Override
	public List<UserOrderDetail> paginglist(PagingBean pagingbean) {
		return uodm.paginglist(pagingbean);
	}
	
	

	


}
