package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.mapper.ProductPhotoMapper;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

	@Autowired
	private ProductPhotoMapper ppm;	

	// ProductCon
	public List<ProductPhoto> photoList(Product product) {
		return ppm.photoList(product);
	}
	
	
	
	
	// AccountCon
	public ProductPhoto getPhoto(int productNo, String color) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("color", color);
		map.put("productNo", productNo);
		return ppm.getPhoto(map);
	}
	
	
	
	
	// AdminCon
	@Override
	public int productinsert(Product product) {
		return ppm.productinsert(product);
	}
	@Override
	public int productinsert2(Product product) {
		return ppm.productinsert2(product);
	}

	@Override
	public int selectproductPhotoNo(Product product) {
		return ppm.selectproductPhotoNo(product);
	}
	@Override
	public int productdelete(Product product) {
		return ppm.productdelete(product);
	}
	@Override
	public int productupdate(Product product) {
		return ppm.productupdate(product);
	}




	@Override
	public List<ProductPhoto> thumPhotoList(int productNo) {
		
		return ppm.thumPhotoList(productNo);
	}
}
