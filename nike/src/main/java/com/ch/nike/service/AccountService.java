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

	Product selectWishThum(int productNo);

	List<Cart> selectCart(String email);

	Product selectCartThum(int product_detail_no);
	
	List<UserOrder> selectUserOrder(String email);

	UserOrderDetail selectOrderDeatail(int orderNo);

	Address selectAddr(int addrNo);



}
