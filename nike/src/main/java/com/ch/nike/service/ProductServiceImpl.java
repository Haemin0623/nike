package com.ch.nike.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Filter;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
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
	@Override
	public List<Product> filterList(Filter filter) {
		return pm.filterList(filter);
	}
	@Override
	public List<Product> listPaging(Filter filter) {
		return pm.listPaging(filter);
	}
	@Override
	public List<Product> filterListPaging(Filter filter) {
		return pm.filterListPaging(filter);
	}
	@Override
	public int getTotal1(Filter filter) {
		return pm.getTotal1(filter);
	}
	@Override
	public int getTotal2(Filter filter) {
		return pm.getTotal2(filter);
	}
	
	
	// AdminCon
	@Override
	public int getTotal(PagingBean pagingbean) {
		return pm.getTotal(pagingbean);
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