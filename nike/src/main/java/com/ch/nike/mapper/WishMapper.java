package com.ch.nike.mapper;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.Wish;



@Mapper
public interface WishMapper {
	
	List<Wish> wishselect(String email);
	List<Wish> selectWish(String email);	// 이메일로 wishlist 가져오기
	Product selectWishThum(int productNo);
	Wish selectWishResult(HashMap<String, Object> map);
	void deleteWish(HashMap<String, Object> map);
	int selectCount();
	void addWish(HashMap<String, Object> map);


}
