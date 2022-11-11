package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.ProductFeature;

public interface ProductFeatureService {
	
	// ProductCon
	// 특정 상품 특징 전체조회
	List<ProductFeature> featureList(int productNo);

}
