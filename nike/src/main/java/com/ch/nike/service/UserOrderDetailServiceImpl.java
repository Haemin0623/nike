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
	public int getTotal(PagingBean pagingbean) {
		return uodm.getTotal(pagingbean);
	}
	@Override
	public List<UserOrderDetail> paginglist(PagingBean pagingbean) {
		return uodm.paginglist(pagingbean);
	}
	@Override
	public int refundchkupdate(UserOrderDetail userOrderDetail) {
		return uodm.refundchkupdate(userOrderDetail);
	}

	// UserOrderCon
	public int currentCount() {
		return uodm.currentCount();
	}
	public void insert(UserOrderDetail userOrderDetail) {
		uodm.insert(userOrderDetail);
	}

}
