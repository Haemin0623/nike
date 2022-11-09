package com.ch.nike.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;


@Mapper
public interface ProductDetailMapper {

	int productinsert(Product product);

	int productupdate(Product product);

}
