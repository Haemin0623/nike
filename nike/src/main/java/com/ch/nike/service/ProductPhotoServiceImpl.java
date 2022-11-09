package com.ch.nike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Product;
import com.ch.nike.mapper.ProductPhotoMapper;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {
	@Autowired
	private ProductPhotoMapper ppm;

	@Override
	public int productinsert(Product product) {
		return ppm.productinsert(product);
	}

	@Override
	public int productupdate(Product product) {
		return ppm.productupdate(product);
	}

	@Override
	public int productinsert2(Product product) {
		return ppm.productinsert2(product);
	}

	@Override
	public int productinsert3(Product product) {
		return ppm.productinsert3(product);
	}



}
