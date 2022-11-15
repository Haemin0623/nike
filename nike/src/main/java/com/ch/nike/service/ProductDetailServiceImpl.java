package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.mapper.ProductDetailMapper;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{
	@Autowired
	private ProductDetailMapper pdm;
	
	// ProductCon
	@Override
	public List<ProductDetail> detailList(int productNo) {
		return pdm.detailList(productNo);
	}	
	
	
	// AdminCon
	@Override
	public int productinsert(Product product) {
		return pdm.productinsert(product);
	}
	@Override
	public int productupdate(Product product) {
		return pdm.productupdate(product);
	}

	// AccountCon
	public int getProductDetailNo(ProductDetail productDetail) {
		return pdm.getProductDetailNo(productDetail);
	}	
	
}
