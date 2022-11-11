package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;

public interface ProductPhotoService {

	// ProductCon
	// 특정 상품 사진 전체 조회
	List<ProductPhoto> photoList(int productNo);
	
	
	
	// AccountCon
	// 특정 상품(+컬러)의 썸네일(1) 사진 조회
	ProductPhoto getPhoto(int productNo, String color);
	
	
	
	// AdminCon
	// 상품등록시 상품사진(1) 등록
	int productinsert(Product product);
	// 상품등록시 상품사진(2) 등록
	int productinsert2(Product product);
	// 상품의 썸네일(1)사진 조회
	int selectproductPhotoNo(Product product);
	// 해당 사진 삭제
	int productdelete(Product product);
	// ******************
	int productupdate(Product product);
	
}
