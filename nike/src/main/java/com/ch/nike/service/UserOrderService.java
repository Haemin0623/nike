package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrder;

public interface UserOrderService {

	List<UserOrder> orderlist();
	List<UserOrder> userorderselect(String email);
	List<UserOrder> selectUserOrder(String email);
	UserOrder selectOrderDetail(int orderNo);
}
