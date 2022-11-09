package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.ProductDetail;
import com.ch.nike.mapper.ProductDetailMapper;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{
	@Autowired
	private ProductDetailMapper pdm;
	public List<ProductDetail> productDetail(int productNo, String color) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("productNo", productNo);
		map.put("color", color);
		return pdm.productDetail(map);
	}

}
