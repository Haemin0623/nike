package com.ch.nike.service;


import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;

public interface ProductPhotoService {

	int productinsert(Product product);

	int productupdate(Product product);

	int productinsert2(Product product);

	int productinsert3(Product product);

	


	List<ProductPhoto> photoList(int productNo);

}
