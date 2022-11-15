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
	private UserOrderMapper uom;

	
	// AccountCon
	public List<UserOrder> selectUserOrder(String email) {
		return uom.selectUserOrder(email);
	}
	public List<UserOrder> selectOrderDetail(int orderNo) {
		return uom.selectOrderDetail(orderNo);
	}
	public UserOrder orderInfoAll(int orderDetailNo) {
		return uom.orderInfoAll(orderDetailNo);
	}
	public List<UserOrder> selectDate(String email) {
		return uom.selectDate(email);
	}

	
	
	// AdminCon
	@Override
	public List<UserOrder> userorderselect(String email) {
		return uom.userorderselect(email);
	}
	@Override
	public int getTotal(PagingBean pagingbean) {
		return uom.getTotal(pagingbean);
	}
	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return uom.paginglist(pagingbean);
	}
	@Override
	public List<UserOrder> paginglistrefundchk(PagingBean pagingbean) {
		return uom.paginglistrefundchk(pagingbean);
	}

	
	// UserOrderCon
	public int currentCount() {
		return uom.currentCount();
	}
	public void insert(UserOrder userOrder) {
		uom.insert(userOrder);
		
	}
	

}