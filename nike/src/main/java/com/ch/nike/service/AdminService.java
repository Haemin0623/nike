package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.Notice;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;

public interface AdminService {

	List<Member> memberlist();

	List<Product> productlist();

	List<UserOrder> orderlist();

	List<QnA> qnalist();

	List<Review> reviewlist();

	List<Notice> noticelist();

	List<Store> storelist();


}
