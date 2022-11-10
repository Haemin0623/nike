package com.ch.nike.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.UserOrderDetail;


@Mapper
public interface UserOrderDetailMapper{

	int getTotal();

	List<UserOrderDetail> paginglist(PagingBean pagingbean);


}
