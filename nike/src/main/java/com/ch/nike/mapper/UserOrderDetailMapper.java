package com.ch.nike.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrderDetail;


@Mapper
public interface UserOrderDetailMapper{

	// AdminCon
	int getTotal(PagingBean pagingbean);
	List<UserOrderDetail> paginglist(PagingBean pagingbean);
	int refundchkupdate(UserOrderDetail userOrderDetail);
	
	
	// UserOrderCon
	int currentCount();
	void insert(UserOrderDetail userOrderDetail);
	int orderCountInOneOrder(int orderNo);
	



}
