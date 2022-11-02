package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.Refund;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.Wish;

public interface AccountService {

	int deleteMember(String email);

	List<Wish> selectWish(String email);

	Product selectWishThum(int productNo);

	List<Cart> selectCart(String email);

	Product selectCartThum(int productDetailNo);
	
	List<UserOrder> selectUserOrder(String email);

	Product selectOrderDetail(int orderNo);

	String selectName(int orderDetailNo);

	int insertRefund(Refund refund);

	int selectRefundNum(int refundNo);

	void updateRefundChk(int orderDetailNo);

	






}
