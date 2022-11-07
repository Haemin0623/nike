package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.mapper.ProductPhotoMapper;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {
	@Autowired
	private ProductPhotoMapper ppm;
	

	public List<ProductPhoto> selectPP(int productNo) {
		return ppm.selectPP(productNo);
	}
	public List<ProductDetail> colorChange(String color, int productNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("color", color);
		map.put("productNo", productNo);
		return ppm.colorChange(map);
	}
}
