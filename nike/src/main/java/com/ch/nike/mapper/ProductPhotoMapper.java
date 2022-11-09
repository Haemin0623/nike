package com.ch.nike.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;


@Mapper
public interface ProductPhotoMapper {

	int productinsert(Product product);

	int productupdate(Product product);

	int productinsert2(Product product);

	int productinsert3(Product product);

}
