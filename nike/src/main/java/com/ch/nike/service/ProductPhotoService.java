package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;

public interface ProductPhotoService {


	List<ProductPhoto> photoList(int productNo);

	List<ProductPhoto> selectPP(int productNo);
	List<ProductDetail> colorChange(String color, int productNo);
	ProductPhoto getPhoto(int productNo, String color);
	
	int productinsert(Product product);
	
	int productupdate(Product product);
	
	int productinsert2(Product product);
	
	int productinsert3(Product product);

}
