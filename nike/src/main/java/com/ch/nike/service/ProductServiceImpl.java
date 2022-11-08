package com.ch.nike.service;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.Product;
import com.ch.nike.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper pm;

	@Override
	public List<Product> list() {
		return pm.list();
	}

	@Override
	public List<Product> productlist(Category category) {
		return pm.productlist(category);
	}

	@Override
	public Product count(Category category) {
		return pm.count(category);
	}

	@Override
	public List<Product> color(Category category) {
		return pm.color(category);
	}

	@Override
	public Product colorcount(Category category) {
		return pm.colorcount(category);
	}
	@Override
	public List<Product> adminproductlist() {
		return pm.adminproductlist();
	}
	public List<Product> selectCartDetail(String email, int productDetailNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("productDetailNo", productDetailNo);
		return pm.selectCartDetail(map);
	}

	public List<Product> selectProduct() {
		return pm.selectProduct();
	}
	public Product selectProductOne(int productNo) {
		return pm.selectProductOne(productNo);
	}

	public Product productInfo(int productNo, String color) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("productNo", productNo);
		map.put("color", color);
		return pm.productInfo(map);
	}




}