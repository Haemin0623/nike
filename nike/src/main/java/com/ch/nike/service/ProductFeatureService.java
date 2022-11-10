package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.ProductFeature;

public interface ProductFeatureService {
	List<ProductFeature> selectFeature(int productNo);
}
