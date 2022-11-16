package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.Filter;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.UserOrderDetail;

public interface ProductService {

	// ProductCon
	// 전체 상품리스트
	List<Product> list();
	// 특정 상품 정보 조회
	Product selectProduct(int productNo);
	// 검색 필터 상품리스트
	List<Product> filterList(Filter filter);
	// 전체 상품리스트 페이징
	List<Product> listPaging(Filter filter);
	// 검색 필터 상품리스트 페이징
	List<Product> filterListPaging(Filter filter);
	// 상품개수 (페이징)
	int getTotal1(Filter filter);
	
	
	// AdminCon
	// 전체 상품 갯수
	int getTotal(PagingBean pagingbean);
	// 전체 상품 리스트(페이징)
	List<Product> paginglist(PagingBean pagingbean);
	// 상품 상세로 상품 정보 조회
	Product select(int productDetailNo);
	// 상품 최대 번호
	int selectproductNo();
	// 상품 등록
	int productinsert(Product product);
	// 
	int productupdate(Product product);
	
	
	List<Product> adminproductlist();
	List<Product> menProductlist();
	int getTotal2(Filter filter);
	
	//상품상세페이지 - 추천상품
	List<Product> recommendList();
	
	


}
