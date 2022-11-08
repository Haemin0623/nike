package com.ch.nike.controller;

import java.awt.Color;
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

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Member;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Refund;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.Wish;
import com.ch.nike.service.AddressService;
import com.ch.nike.service.CartService;
import com.ch.nike.service.MemberService;
import com.ch.nike.service.ProductPhotoService;
import com.ch.nike.service.ProductService;
import com.ch.nike.service.RefundService;
import com.ch.nike.service.UserOrderService;
import com.ch.nike.service.WishService;

@Controller
public class AccountController {
	@Autowired
	private MemberService ms;
	@Autowired
	private WishService ws;
	@Autowired
	private CartService cs;
	@Autowired
	private ProductService ps;
	@Autowired
	private UserOrderService uos;
	@Autowired
	private RefundService rs;
	@Autowired
	private AddressService as;
	@Autowired
	private ProductPhotoService pps;
	
	@RequestMapping("/account/mypage.do")	// mypage로 이동 by선희
	public String mypage(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		return "account/mypage";
	}
	@RequestMapping("/account/profile.do")	// mypage에서 profile로 이동 by선희
	public String profile(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		Member member = ms.select(email);
		model.addAttribute("member", member);
		return "account/profile";
	}
	@RequestMapping("/account/deleteMember.do")	// mypage - profile에서 회원탈퇴 by선희
	public String deleteMember(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		int result = ms.deleteMember(email);
		model.addAttribute("result", result);
		return "account/deleteMember";
	}
	@RequestMapping("/account/wishList.do")		// 로그인한 회원의 wishlist 불러오기 by선희
	public String wishList(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<Wish> wishList = ws.selectWish(email);	// email에 대한 wish 조회
		List<Product> list = new ArrayList<>();	
		for (Wish wish:wishList) {
			if (wish != null) {
				Product product = ws.selectWishThum(wish.getProductNo(), wish.getColor());
				list.add(product);
			}
		}
		model.addAttribute("wish", wishList);
		model.addAttribute("list", list);
		return "account/wishList";
	}
	@RequestMapping("/account/cartList.do")		// 로그인한 회원의 장바구니 불러오기 by선희
	public String cartList(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		// 1 이메일에 대한 모든 카트 리스트 구해
		List<Cart> cartList = cs.selectCart(email);
		List<Product> list = new ArrayList<>();
		for (Cart cart:cartList) {	// 2. 카트 리스트에서 하나 꺼내서 그 상품에 대한 디테일번호로 
//			if (cart != null) {
//				List<Product> productList = ps.selectCartDetail(email, cart.getProductDetailNo());	// p, pd, c
//				for (Product product:productList) {
//					if (product != null) {
//						// ProductPhoto pp = pps.getPhoto(product.getProductNo(), product.getColor());
//						list.add(product);
//						
//					}
//					
//				}
//			}
		}
		model.addAttribute("cart", cartList);
		model.addAttribute("list", list);
		return "account/cartList";
	}
	@RequestMapping("/account/orders.do")		// 로그인한 회원의 주문내역 불러오기 by선희
	public String orders(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<UserOrder> userOrder = uos.selectUserOrder(email);
		List<Product> list = new ArrayList<>();
		for (UserOrder user:userOrder) {
			if (user != null) {
//				order_no로 order,address테이블,user_order_detail 모두 다 나와야함.
				Product orderDetail = uos.selectOrderDetail(user.getOrderNo());
				list.add(orderDetail);
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("userOrder", userOrder);
		return "account/orders";
	}
	@RequestMapping("/account/ordersDetail.do") 	// 로그인한 회원의 주문내역 상세 불러오기 by선희
	public String ordersDetail(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<UserOrder> userOrder = uos.selectUserOrder(email);
		List<Product> list = new ArrayList<>();
		
		for (UserOrder user:userOrder) {
			if (user != null) {
				Product orderDetail = uos.selectOrderDetail(user.getOrderNo());
				list.add(orderDetail);
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("userOrder", userOrder);
		return "account/ordersDetail";
	}
	@RequestMapping("/account/refundForm.do")		// 주문내역 - 환불신청으로 넘어가기 by선희
	public String refundForm(int orderDetailNo, Model model, HttpSession session) {
		String productName = rs.selectName(orderDetailNo);
		model.addAttribute("productName", productName);
		model.addAttribute("orderDetailNo", orderDetailNo);
		return "account/refundForm";
	}
	@RequestMapping("/account/refund.do")	// 환불신청하기 by선희
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
			int refundNum = rs.selectRefundNum();
			refund.setRefundNo(refundNum);
			result = rs.insertRefund(refund);
			rs.updateRefundChk(refund.getOrderDetailNo());
		} else result = -1;  // 이미 있으니 입력하지마
		model.addAttribute("result", result);
		return "account/refund";
	}
	@RequestMapping("/account/address.do")	// 배송지관리로 이동 by선희
	public String address(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<Address> addrList = as.selectAddr(email);
		model.addAttribute("addrList", addrList);
		return "account/address";
	}
	@RequestMapping("/account/addAddr.do")
	public String addAddr(Model model, HttpSession session) {
		
		return "account/addAddr";
	}
}
