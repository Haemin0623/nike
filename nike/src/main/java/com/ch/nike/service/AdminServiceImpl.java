package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.Notice;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.Wish;
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

	@Override
	public List<Notice> noticelist() {
		return am.noticelist();
	}

	@Override
	public List<Store> storelist() {
		return am.storelist();
	}

	@Override
	public Member memberselect(String email) {
		return am.memberselect(email);
	}

	@Override
	public List<Review> reviewselect(String email) {
		return am.reviewselect(email);
	}

	@Override
	public List<Product> wishselect(String email) {
		return am.wishselect(email);
	}

	@Override
	public List<UserOrder> userorderselect(String email) {
		return am.userorderselect(email);
	}
}
