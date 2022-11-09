package com.ch.nike.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.Member;
import com.ch.nike.dto.PagingBean;
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
	public Product selectCartThum(int productDetailNo) {
		return pm.selectCartThum(productDetailNo);
	}

	@Override
	public List<Product> selectProduct() {
		return pm.selectProduct();
	}

	@Override
	public List<Product> paginglist(PagingBean pagingbean) {
		return pm.paginglist(pagingbean);
	}

	@Override
	public int productinsert(Product product) {
		return pm.productinsert(product);
	}

	@Override
	public int selectproductNo() {
		return pm.selectproductNo();
	}

	@Override
	public int getTotal() {
		return pm.getTotal();
	}

	@Override
	public Product select(int productDetailNo) {
		return pm.select(productDetailNo);
	}

	@Override
	public int productupdate(Product product) {
		return pm.productupdate(product);
	}
}