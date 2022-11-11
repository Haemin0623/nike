package com.ch.nike.mapper;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.Wish;



@Mapper
public interface WishMapper {
	
	// WishCon
	Wish selectByEmail(Wish wish);
	int insert(Wish wish);
	void delete(int wishNo);	
	
	// AccountCon
	List<Wish> wishList(String email);


}
