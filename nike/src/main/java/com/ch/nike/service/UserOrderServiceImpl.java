package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.PagingBean;
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
	public List<UserOrder> selectOrderDetail(int orderNo) {
		return uod.selectOrderDetail(orderNo);
	}
	public UserOrder orderInfoAll(int orderDetailNo) {
		return uod.orderInfoAll(orderDetailNo);
	}
	public List<UserOrder> selectDate(String email) {
		return uod.selectDate(email);
	}

	
	
	// AdminCon
	@Override
	public List<UserOrder> userorderselect(String email) {
		return uod.userorderselect(email);
	}
	@Override
	public int getTotal(PagingBean pagingbean) {
		return uod.getTotal(pagingbean);
	}
	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return uod.paginglist(pagingbean);
	}
	@Override
	public List<UserOrder> paginglistrefundchk(PagingBean pagingbean) {
		return uod.paginglistrefundchk(pagingbean);
	}
	

}