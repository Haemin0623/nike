package com.ch.nike.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Member;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.UserOrderDetail;
import com.ch.nike.service.AddressService;
import com.ch.nike.service.CartService;
import com.ch.nike.service.MemberService;
import com.ch.nike.service.UserOrderDetailService;
import com.ch.nike.service.UserOrderService;

@Controller
public class UserOrderController {
	@Autowired
	CartService cs;
	@Autowired
	AddressService as;
	@Autowired
	MemberService ms;
	@Autowired
	UserOrderService uos;
	@Autowired
	UserOrderDetailService uods;
	
	@RequestMapping("/product/checkout.do")
	public String paymentForm(Model model, HttpSession session) {
		
		String email = (String) session.getAttribute("email");
		Member member = ms.select(email);
		
		Address defaultAddress = as.getDefaulAddress(email);
		
		
		List <Cart> cartList = cs.cartList(email);
		int totalPrice = 0;
		for (Cart cart:cartList) {
			totalPrice += (cart.getPrice()*cart.getCartQuantity());
			cart.setTotalPrice(cart.getPrice() * cart.getCartQuantity());
		}
		
		
		
		model.addAttribute("defaultAddress", defaultAddress);
		model.addAttribute("email",email);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("cartList", cartList);
		model.addAttribute("member",member);
		return "product/checkOut";
	}
	
	   @RequestMapping("/product/paymentAPI.do")
	   public String paymentAPI(int selectedAddrNo, Model model, HttpSession session) {
		   System.out.println("결제 성공?!!!!");
		   // 먼저 카트리스에 있는 프로덕트 디테일 넘버 가져오기
		   String email = (String) session.getAttribute("email");
		   // orderNo 구해서 userOrder에 저장하고 그 오더 넘버에 해당하는 
		   UserOrder userOrder = new UserOrder();
		   UserOrderDetail userOrderDetail = new UserOrderDetail();
		   int orderNo = uos.currentCount();
		   userOrder.setOrderNo(orderNo);
		   userOrder.setAddrNo(selectedAddrNo);
		   userOrder.setEmail(email);
		   uos.insert(userOrder);
		   
		   List<Cart> cartList = cs.cartList(email);
		   for (Cart cart:cartList) {
			   int orderDetailNo = uods.currentCount();
			   userOrderDetail.setOrderDetailNo(orderDetailNo);
			   userOrderDetail.setOrderNo(orderNo);
			   userOrderDetail.setProductDetailNo(cart.getProductDetailNo());
			   userOrderDetail.setOrderQuantity(cart.getCartQuantity());
			   uods.insert(userOrderDetail);
			   
		   }
		   
		   cs.deleteAfterOrder(email);
		   
		   return "redirect:/account/orderList.do";
	   }
}
