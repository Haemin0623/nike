package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrder;


@Mapper
public interface UserOrderMapper {

	// AccountCon
	List<UserOrder> selectUserOrder(String email);
	UserOrder selectOrderDetail(int orderNo);
	
	
	// AdminCon
	List<UserOrder> userorderselect(String email);
	int getTotal();
	List<UserOrder> paginglist(PagingBean pagingbean);
	
	


}
