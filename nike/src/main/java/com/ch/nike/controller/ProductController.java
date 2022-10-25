package com.ch.nike.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Product;
import com.ch.nike.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@RequestMapping("main.do")
	public String main(Model model) {
		List<Product> product = ps.list();
		model.addAttribute("product", product);
		return "main";
	}
	
}
