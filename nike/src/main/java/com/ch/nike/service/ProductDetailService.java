package com.ch.nike.service;


import com.ch.nike.dto.Product;

import java.util.List;
import com.ch.nike.dto.ProductDetail;

public interface ProductDetailService {
	
	int productinsert(Product product);

	int productupdate(Product product);

	List<ProductDetail> detailList(int productNo);

}
