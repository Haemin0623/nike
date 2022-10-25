package com.ch.nike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Wish;
import com.ch.nike.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService as;
	@RequestMapping("/account/profile.do")
	public String profile() {
		
//		profile에 list로 받았으니 list로 보내기
		return "account/profile";
	}
	@RequestMapping("/account/deleteMember.do")
	public String deleteMember(String email, Model model) {
		int result = as.deleteMember(email);
		model.addAttribute("result", result);
		return "account/deleteMember.do";
	}
	@RequestMapping("/account/wishList.do")
	public String wishList(String email, Model model) {
		Wish wish = as.selectWish(email);
		ProductPhoto thumbnail = as.selectThum(wish.getProduct_no());
		Product product = as.selectProduct(wish.getProduct_no());
		model.addAttribute("wish", wish);
		model.addAttribute("product", product);
		model.addAttribute("thumbnail", thumbnail);
		return "account/wishList.do";
	}
	@RequestMapping("/account/cartList.do")
	public String cartList(String email, Model model) {
		Cart cart = as.selectCart(email);
		ProductPhoto thumbnail = as.selectThum(cart.getProduct_no());
		Product product = as.selectProduct(cart.getProduct_no());
		model.addAttribute("cart", cart);
		model.addAttribute("product", product);
		model.addAttribute("thumbnail", thumbnail);
		return "account/cartList.do";
	}
}
