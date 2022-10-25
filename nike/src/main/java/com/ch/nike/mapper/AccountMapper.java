package com.ch.nike.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Wish;

@Mapper
public interface AccountMapper {
	int deleteMember(String email);

	Wish selectWish(String email);

	ProductPhoto selectThum(int product_no);

	Product selectProduct(int product_no);

	Cart selectCart(String email);

}
