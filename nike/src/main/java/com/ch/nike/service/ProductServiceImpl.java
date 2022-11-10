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
	public Product selectsoo(int productNo) {
		return pm.select(productNo);
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