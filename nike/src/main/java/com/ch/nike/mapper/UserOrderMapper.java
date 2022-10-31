package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.UserOrder;


@Mapper
public interface UserOrderMapper {

	List<UserOrder> orderlist();

	List<UserOrder> userorderselect(String email);


}
