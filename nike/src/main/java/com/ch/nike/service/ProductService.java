package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.Product;

public interface ProductService {

	List<Product> list();

	List<Product> productlist(Category category);

	Product count(Category category);
}
