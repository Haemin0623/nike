package com.ch.nike.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Wish;
import com.ch.nike.service.CartService;
import com.ch.nike.service.WishService;

@Controller
public class CartController {
	@Autowired
	private CartService cs;
	@RequestMapping("/product/addCart.do")	// 장바구니 추가 및 삭제 by 선희
	public String addCart(int productNo, String size, Model model, HttpSession session) {
		int result = 0;
		result = cs.addCart(productNo, size);
		return "product/addCart";
		
	}

}
