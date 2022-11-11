package com.ch.nike.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;

@Mapper
public interface ProductMapper {

	// productCon
	List<Product> list();
	Product selectsoo(int productNo);
	
	
	
	// AdminCon
	int getTotal();
	List<Product> paginglist(PagingBean pagingbean);
	Product select(int productDetailNo);
	int selectproductNo();
	int productinsert(Product product);
	int productupdate(Product product);
	
	List<Product> adminproductlist();
	List<Product> menProductlist();

}
