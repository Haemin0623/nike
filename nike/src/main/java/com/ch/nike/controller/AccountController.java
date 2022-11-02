package com.ch.nike.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Member;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.Refund;
import com.ch.nike.dto.UserOrder;
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
		return "account/deleteMember";
	}
	@RequestMapping("/account/wishList.do")
	public String wishList(String email, Model model) {
		List<Wish> wishList = as.selectWish(email);
		List<Product> list = new ArrayList<>();
		for (Wish wish:wishList) {
			if (wish != null) {
				Product product = as.selectWishThum(wish.getProductNo());
				list.add(product);
			}
		}
		model.addAttribute("wish", wishList);
		model.addAttribute("list", list);
		return "account/wishList";
	}
	@RequestMapping("/account/cartList.do")
	public String cartList(String email, Model model) {
		List<Cart> cartList = as.selectCart(email);
		List<Product> list = new ArrayList<>();
		for (Cart cart:cartList) {
			if (cart != null) {
				Product product = as.selectCartThum(cart.getProductDetailNo());
				list.add(product);
			}
		}
		model.addAttribute("cart", cartList);
		model.addAttribute("list", list);
		return "account/cartList";
	}
	@RequestMapping("/account/orders.do")
	public String orders(String email, Model model) {
		List<UserOrder> userOrder = as.selectUserOrder(email);
		List<Product> list = new ArrayList<>();
		for (UserOrder user:userOrder) {
			if (user != null) {
//				order_no로 order,address테이블,user_order_detail 모두 다 나와야함.
				Product orderDetail = as.selectOrderDetail(user.getOrderNo());
				list.add(orderDetail);
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("userOrder", userOrder);
		return "account/orders";
	}
	@RequestMapping("/account/ordersDetail.do")
	public String ordersDetail(String email, Model model) {
		List<UserOrder> userOrder = as.selectUserOrder(email);
		List<Product> list = new ArrayList<>();
		
		for (UserOrder user:userOrder) {
			if (user != null) {
				Product orderDetail = as.selectOrderDetail(user.getOrderNo());
				list.add(orderDetail);
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("userOrder", userOrder);
		return "account/ordersDetail";
	}
	@RequestMapping("/account/refundForm.do")
	public String refundForm(int orderDetailNo, Model model) {
		String productName = as.selectName(orderDetailNo);
		model.addAttribute("productName", productName);
		model.addAttribute("orderDetailNo", orderDetailNo);
		return "account/refundForm";
	}
	@RequestMapping("/account/refund.do")
	public String refund(Refund refund, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면 입력한 데이터, member2 DB에 있는 데이터 중복여부 체크
		if (refund == null) {
			String refundPhoto = refund.getFile().getOriginalFilename();
			// 파일명을 변경하고 싶으면 UUID 또는 long으로 날자 데이터
			refund.setRefundPhoto(refundPhoto);
			String real = "src/main/resources/static/images/refund_photo";
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+refundPhoto));
			fos.write(refund.getFile().getBytes());
			fos.close();
			int refundNum = as.selectRefundNum(refund.getRefundNo());
			refund.setRefundNo(refundNum);
			result = as.insertRefund(refund);
			as.updateRefundChk(refund.getOrderDetailNo());
		} else result = -1;  // 이미 있으니 입력하지마
		model.addAttribute("result", result);
		return "account/refund";
	}
}
