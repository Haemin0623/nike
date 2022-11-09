package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;


@Mapper
public interface ReviewMapper {

	List<Review> reviewlist();

	List<Review> reviewselect(String email);

	List<UserOrder> paginglist(PagingBean pagingbean);

	int getTotal();


}
