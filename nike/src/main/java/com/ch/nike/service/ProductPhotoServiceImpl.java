package com.ch.nike.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.ProductPhoto;

import com.ch.nike.mapper.ProductPhotoMapper;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

	@Autowired
	private ProductPhotoMapper ppm;

	@Override

	public List<ProductPhoto> photoList(int productNo) {
		return ppm.photoList(productNo);
	}
}
