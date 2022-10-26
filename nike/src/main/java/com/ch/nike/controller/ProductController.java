package com.ch.nike.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Category;
import com.ch.nike.dto.Product;
import com.ch.nike.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@RequestMapping("main.do") //메인 최하단 하단 신발 리스트
	public String main(Model model) {
		List<Product> product = ps.list();
		model.addAttribute("product", product);
		return "main";
	}
	
	@RequestMapping("productList.do") // 상품리스트 상품 리스트불러오기 (대분류,소분류)
	public String productList(Model model, Category category ) {
		List<Product> product = ps.productlist(category);
		model.addAttribute("product",product);
		return "productList";
	}
}
