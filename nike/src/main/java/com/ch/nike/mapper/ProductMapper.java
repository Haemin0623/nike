package com.ch.nike.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.Product;

@Mapper
public interface ProductMapper {

	List<Product> list();

	List<Product> productlist(Category category);



}
