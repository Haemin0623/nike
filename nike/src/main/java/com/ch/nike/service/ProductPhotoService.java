package com.ch.nike.service;


import java.util.List;
import com.ch.nike.dto.ProductPhoto;

public interface ProductPhotoService {

	List<ProductPhoto> photoList(int productNo);

}
