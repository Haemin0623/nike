package com.ch.nike.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.UserOrderDetail;
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
		List<Wish> wishList = as.selectWish(email);
		List<Product> list = new ArrayList<>();
		for (Wish wish:wishList) {
			if (wish != null) {
				Product product = as.selectProThum(wish.getProductNo());
				list.add(product);
			}
		}
		model.addAttribute("wish", wishList);
		model.addAttribute("list", list);
		return "account/wishList.do";
	}
	@RequestMapping("/account/cartList.do")
	public String cartList(String email, Model model) {
		List<Cart> cartList = as.selectCart(email);
		List<Product> list = new ArrayList<>();
		for (Cart cart:cartList) {
			if (cart != null) {
				Product product = as.selectProThum(cart.getProductNo());
				list.add(product);
			}
		}
		model.addAttribute("cart", cartList);
		model.addAttribute("list", list);
		return "account/cartList.do";
	}
	@RequestMapping("/account/orders.do")
	public String orders(String email, Model model) {
		List<UserOrder> userOrder = as.selectUserOrder(email);
		List<Product> list = new ArrayList<>();
		for (UserOrder user:userOrder) {
			if (user != null) {
//				order_no로 order,address테이블,uod 모두 다 나와야함.
				UserOrderDetail userOrderDetail = as.selectOrderDeatail(user.getOrderNo());
				
			}
		}
		model.addAttribute("userOrder", userOrder);
		return "account/orders.do";
	}
}
