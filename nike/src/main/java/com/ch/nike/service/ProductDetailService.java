package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.ProductDetail;

public interface ProductDetailService {

	List<ProductDetail> Color(int productNo);
	List<ProductDetail> Size(int productNo);


	
}
