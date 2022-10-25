package com.ch.nike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Wish;
import com.ch.nike.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper am;

	public int deleteMember(String email) {
		return am.deleteMember(email);
	}

	public Wish selectWish(String email) {
		return am.selectWish(email);
	}

	public ProductPhoto selectThum(int product_no) {
		return am.selectThum(product_no);
	}

	public Product selectProduct(int product_no) {
		return am.selectProduct(product_no);
	}

	@Override
	public Cart selectCart(String email) {
		return am.selectCart(email);;
	}
}
