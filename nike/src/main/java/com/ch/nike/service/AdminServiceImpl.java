package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper am;

	@Override
	public List<Member> memberlist() {
		return am.memberlist();
	}

	@Override
	public List<Product> productlist() {
		return am.productlist();
	}

	@Override
	public List<UserOrder> orderlist() {
		return am.orderlist();
	}

	@Override
	public List<QnA> qnalist() {
		return am.qnalist();
	}

	@Override
	public List<Review> reviewlist() {
		return am.reviewlist();
	}
}
