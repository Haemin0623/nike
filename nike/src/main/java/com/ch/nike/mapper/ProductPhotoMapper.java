package com.ch.nike.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.nike.dto.ProductPhoto;

@Mapper
public interface ProductPhotoMapper {


	int productinsert(Product product);

	int productupdate(Product product);

	int productinsert2(Product product);

	int productinsert3(Product product);
	List<ProductPhoto> photoList(int productNo);

}
