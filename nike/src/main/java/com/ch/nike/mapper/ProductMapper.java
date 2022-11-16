package com.ch.nike.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Filter;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;

@Mapper
public interface ProductMapper {

	// productCon
	List<Product> list();
	Product selectProduct(int productNo);
	List<Product> filterList(Filter filter);
	List<Product> listPaging(Filter filter);
	List<Product> filterListPaging(Filter filter);
	int getTotal1(Filter filter);
	int getTotal2(Filter filter);
	
	
	
	// AdminCon
	int getTotal(PagingBean pagingbean);
	List<Product> paginglist(PagingBean pagingbean);
	Product select(int productDetailNo);
	int selectproductNo();
	int productinsert(Product product);
	int productupdate(Product product);
	
	List<Product> adminproductlist();
	List<Product> menProductlist();
	List<Product> recommendList();

}
