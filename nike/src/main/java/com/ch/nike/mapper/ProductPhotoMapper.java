package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;

@Mapper
public interface ProductPhotoMapper {

	List<ProductPhoto> photoList(int productNo);

	List<ProductPhoto> selectPP(int productNo);
	List<ProductDetail> colorChange(HashMap<String, Object> map);
	ProductPhoto getPhoto(HashMap<String, Object> map);

	int productinsert(Product product);

	int productupdate(Product product);

	int productinsert2(Product product);

	int productinsert3(Product product);
}
