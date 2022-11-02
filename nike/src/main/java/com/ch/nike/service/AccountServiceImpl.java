package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.Refund;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.Wish;
import com.ch.nike.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper am;

	public int deleteMember(String email) {
		return am.deleteMember(email);
	}

	public List<Wish> selectWish(String email) {
		return am.selectWish(email);
	}

	public Product selectWishThum(int productNo) {
		return am.selectWishThum(productNo);
	}
	
	public Product selectCartThum(int productDetailNo) {
		return am.selectCartThum(productDetailNo);
	}


	public List<Cart> selectCart(String email) {
		return am.selectCart(email);
	}

	public List<UserOrder> selectUserOrder(String email) {
		return am.selectUserOrder(email);
	}

	public Product selectOrderDetail(int orderNo) {
		return am.selectOrderDetail(orderNo);
	}

	public String selectName(int orderDetailNo) {
		return am.selectName(orderDetailNo);
	}

	public int insertRefund(Refund refund) {
		return am.insertRefund(refund);
	}

	@Override
	public int selectRefundNum(int refundNo) {
		return am.selectRefundNum(refundNo);
	}

	@Override
	public void updateRefundChk(int orderDetailNo) {
		am.updateRefundChk(orderDetailNo);
	}

	





}
