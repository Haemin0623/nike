package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;

@Mapper
public interface ProductDetailMapper {

	// ProductCon
	List<ProductDetail> detailList(int productNo);
	
	
	// AdminCon
	int productinsert(Product product);
	int productupdate(Product product);

	// AccountCon
	int getProductDetailNo(ProductDetail productDetail);



}
