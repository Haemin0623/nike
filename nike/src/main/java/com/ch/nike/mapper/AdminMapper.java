package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;

@Mapper
public interface AdminMapper {

	List<Member> memberlist();

	List<Product> productlist();

	List<UserOrder> orderlist();

	List<QnA> qnalist();

	List<Review> reviewlist();

}
