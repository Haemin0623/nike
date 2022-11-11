package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.ProductFeature;
import com.ch.nike.mapper.ProductFeatureMapper;

@Service
public class ProductFeatureServiceImpl implements ProductFeatureService{
	@Autowired
	private ProductFeatureMapper pfm;

	// ProductCon
	@Override
	public List<ProductFeature> featureList(int productNo) {
		return pfm.featureList(productNo);
	}

	
	
}
