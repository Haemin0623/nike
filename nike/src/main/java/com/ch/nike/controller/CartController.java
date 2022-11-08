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
	public String addCart(int productNo, String size, String color, Model model, HttpSession session) {
		int result = 0;
		if (session.getAttribute("email") != null) {
			String email = (String) session.getAttribute("email");
			int productDetailNo = cs.getDetailNo(productNo, size, color);
			int cartNoCount = cs.countCartNo(email, productDetailNo);
			if (cartNoCount == 1) {	// 있으면 
				cs.updateCartQuantity(email, productDetailNo);
				result = 2;
			} else {				// 없으면
				int newCartNo = cs.cartCount();
				cs.addCart(newCartNo, email, productDetailNo);
				result = 1;
			}
		} else {
			result = -1;	// 로그인 안한 경우
		}
		model.addAttribute("result", result);
		model.addAttribute("productNo", productNo);
		model.addAttribute("color", color);
		return "product/addCart";
		
	}
	@RequestMapping("/product/deleteCart.do")
	public String deleteCart(int cartNo, Model model, HttpSession session) {
		cs.deleteCart(cartNo);
		int result = 1;
		model.addAttribute("result", result);
		return "account/deleteCart";
	}

}
