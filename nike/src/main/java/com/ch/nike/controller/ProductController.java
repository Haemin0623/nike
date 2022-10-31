package com.ch.nike.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/") //메인 최하단 하단 신발 리스트 by창률 // 로그아웃 위한 세션작업 by수인
	public String main(Model model, HttpSession session) {
		List<Product> product = ps.list();
		String email = (String) session.getAttribute("email"); //by 수인
		model.addAttribute("product", product);
		model.addAttribute("email", email); //by 수인
		return "main";
	}
	
	@RequestMapping("/productList.do") // 상품리스트 상품 리스트불러오기 (대분류,소분류), 상품수체크 by창률
	public String productList(Model model, Category category ) {
		List<Product> product = ps.productlist(category);
		Product product2 = ps.count(category);
		List<Product> product3 = ps.color(category); 
		Product product4 = ps.colorcount(category);
		model.addAttribute("product",product);
		model.addAttribute("category",category);
		model.addAttribute("productcount",product2);
		model.addAttribute("color",product3);
		model.addAttribute("colorcount",product4);
		
		return "product/productList";
	}
	
}
