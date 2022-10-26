package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.UserOrderDetail;
import com.ch.nike.dto.Wish;

@Mapper
public interface AccountMapper {
	int deleteMember(String email);

	List<Wish> selectWish(String email);

	Product selectCartThum(int product_detail_no);

	List<Cart> selectCart(String email);

	List<UserOrder> selectUserOrder(String email);

	UserOrderDetail selectOrderDeatail(int orderNo);

	Address selectAddr(int addrNo);

}
