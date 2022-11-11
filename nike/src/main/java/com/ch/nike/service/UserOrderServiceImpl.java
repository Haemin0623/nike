package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.mapper.UserOrderMapper;

@Service
public class UserOrderServiceImpl implements UserOrderService{
	@Autowired
	private UserOrderMapper uod;

	
	// AccountCon
	public List<UserOrder> selectUserOrder(String email) {
		return uod.selectUserOrder(email);
	}
	public UserOrder selectOrderDetail(int orderNo) {
		return uod.selectOrderDetail(orderNo);
	}
	
	
	
	// AdminCon
	@Override
	public List<UserOrder> userorderselect(String email) {
		return uod.userorderselect(email);
	}
	@Override
	public int getTotal() {
		return uod.getTotal();
	}
	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return uod.paginglist(pagingbean);
	}
	

}