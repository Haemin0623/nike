package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;

public interface ProductService {

	List<Product> list();
	Product selectsoo(int productNo);

	List<Product> productlist(Category category);

	Product count(Category category);

	List<Product> color(Category category);

	Product colorcount(Category category);
	List<Product> adminproductlist();
	
	Product selectCartThum(int productDetailNo);

	List<Product> selectProduct();

	List<Product> paginglist(PagingBean pagingbean);

	int productinsert(Product product);

	int selectproductNo();

	int getTotal();

	Product select(int productDetailNo);

	int productupdate(Product product);
}
