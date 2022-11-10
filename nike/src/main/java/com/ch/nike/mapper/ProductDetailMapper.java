package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;

@Mapper
public interface ProductDetailMapper {
	List<ProductDetail> productDetail(HashMap<String, Object> map);
	
	int productinsert(Product product);

	int productupdate(Product product);


}
