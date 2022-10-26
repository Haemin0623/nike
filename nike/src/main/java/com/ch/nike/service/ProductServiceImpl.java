package com.ch.nike.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.Product;
import com.ch.nike.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper pd;

	@Override
	public List<Product> list() {
		return pd.list();
	}

	@Override
	public List<Product> productlist(Category category) {
		return pd.productlist(category);
	}

}