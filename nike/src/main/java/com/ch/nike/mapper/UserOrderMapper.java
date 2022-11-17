package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrder;


@Mapper
public interface UserOrderMapper {

	// AccountCon
	UserOrder selectUserOrder(int orderNo);
	List<UserOrder> selectOrderDetail(int orderNo);
	UserOrder orderInfoAll(int orderDetailNo);
	List<UserOrder> selectDate(String email);

	
	// AdminCon
	List<UserOrder> userorderselect(String email);
	int getTotal(PagingBean pagingbean);
	List<UserOrder> paginglist(PagingBean pagingbean);
	List<UserOrder> paginglistrefunchk(PagingBean pagingbean);
	List<UserOrder> paginglistrefundchk(PagingBean pagingbean);
	
	
	
	// UserOrderCon
	int currentCount();
	void insert(UserOrder userOrder);
	List<UserOrder> orderList(String email);
	
	
	


}
