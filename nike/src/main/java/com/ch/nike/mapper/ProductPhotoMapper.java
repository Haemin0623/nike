package com.ch.nike.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;

@Mapper
public interface ProductPhotoMapper {

	// ProductCon
	List<ProductPhoto> photoList(int productNo);

	
	
	// AccountCon
	ProductPhoto getPhoto(HashMap<String, Object> map);
	
	
	
	// AdminCon
	int productinsert(Product product);
	int productinsert2(Product product);
	int selectproductPhotoNo(Product product);
	int productdelete(Product product);
	int productupdate(Product product);

}
