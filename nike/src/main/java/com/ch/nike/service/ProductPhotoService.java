package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;

public interface ProductPhotoService {

	List<ProductPhoto> selectPP(int productNo);
	List<ProductDetail> colorChange(String color, int productNo);
}
