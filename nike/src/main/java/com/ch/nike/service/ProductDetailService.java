package com.ch.nike.service;


import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;

public interface ProductDetailService {

	List<ProductDetail> productDetail(int productNo, String color);

	int productinsert(Product product);

	int productupdate(Product product);

	

}
