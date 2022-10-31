package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.UserOrder;

public interface UserOrderService {

	List<UserOrder> orderlist();
	List<UserOrder> userorderselect(String email);
}
