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

	@Override
	public List<UserOrder> orderlist() {
		return uod.orderlist();
	}
	@Override
	public List<UserOrder> userorderselect(String email) {
		return uod.userorderselect(email);
	}
	public List<UserOrder> selectUserOrder(String email) {
		return uod.selectUserOrder(email);
	}
	public Product selectOrderDetail(int orderNo) {
		return uod.selectOrderDetail(orderNo);
	}
	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return uod.paginglist(pagingbean);
	}
	@Override
	public int getTotal() {
		return uod.getTotal();
	}
}