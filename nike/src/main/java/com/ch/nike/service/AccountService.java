package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.UserOrderDetail;
import com.ch.nike.dto.Wish;

public interface AccountService {

	int deleteMember(String email);

	List<Wish> selectWish(String email);

	Product selectProThum(int product_no);

	List<Cart> selectCart(String email);

	List<UserOrder> selectUserOrder(String email);

	UserOrderDetail selectOrderDeatail(int orderNo);

	Address selectAddr(int addrNo);

}
