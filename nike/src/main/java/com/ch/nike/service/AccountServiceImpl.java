package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.UserOrderDetail;
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
		return null;
	}
	
	public Product selectCartThum(int product_detail_no) {
		return am.selectCartThum(product_detail_no);
	}


	public List<Cart> selectCart(String email) {
		return am.selectCart(email);
	}

	public List<UserOrder> selectUserOrder(String email) {
		return am.selectUserOrder(email);
	}

	public UserOrderDetail selectOrderDeatail(int orderNo) {
		return am.selectOrderDeatail(orderNo);
	}

	public Address selectAddr(int addrNo) {
		return am.selectAddr(addrNo);
	}

}
