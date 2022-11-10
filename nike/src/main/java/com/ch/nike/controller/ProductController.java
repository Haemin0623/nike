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
		model.addAttribute("product", product);
		return "nike_main";

	}
	
	@RequestMapping("/product/newReleases.do")
	public String newReleases(Model model) {
		List<Product> productList = ps.list();
		model.addAttribute("productList", productList);
		return "product/newReleases";
	}
	
	
}
