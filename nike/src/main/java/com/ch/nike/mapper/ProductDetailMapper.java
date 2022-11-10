package com.ch.nike.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.nike.dto.ProductDetail;

@Mapper
public interface ProductDetailMapper {


	int productinsert(Product product);

	int productupdate(Product product);

	List<ProductDetail> detailList(int productNo);


}
