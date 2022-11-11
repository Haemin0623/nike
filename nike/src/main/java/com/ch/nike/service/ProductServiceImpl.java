package com.ch.nike.service;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrderDetail;
import com.ch.nike.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper pm;
	
	// ProductCon
	@Override
	public List<Product> list() {
		return pm.list();
	}
	@Override
	public Product selectsoo(int productNo) {
		return pm.select(productNo);
	}
	
	
	
	// AdminCon
	@Override
	public int getTotal() {
		return pm.getTotal();
	}
	@Override
	public List<Product> paginglist(PagingBean pagingbean) {
		return pm.paginglist(pagingbean);
	}
	@Override
	public Product select(int productDetailNo) {
		return pm.select(productDetailNo);
	}
	@Override
	public int selectproductNo() {
		return pm.selectproductNo();
	}
	@Override
	public int productinsert(Product product) {
		return pm.productinsert(product);
	}
	@Override
	public int productupdate(Product product) {
		return pm.productupdate(product);
	}
	
	
	
	@Override
	public List<Product> adminproductlist() {
		return pm.adminproductlist();
	}
	@Override
	public List<Product> menProductlist() {
		return pm.menProductlist();
	}

}