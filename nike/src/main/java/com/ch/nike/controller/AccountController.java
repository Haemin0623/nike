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

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Member;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Refund;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.Wish;
import com.ch.nike.service.AddressService;
import com.ch.nike.service.CartService;
import com.ch.nike.service.MemberService;
import com.ch.nike.service.ProductPhotoService;
import com.ch.nike.service.ProductService;
import com.ch.nike.service.RefundService;
import com.ch.nike.service.ReviewPhotoService;
import com.ch.nike.service.ReviewService;
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
	@Autowired
	private ReviewService rvs;
	@Autowired
	private ReviewPhotoService rps;
	
	@RequestMapping("/account/mypageSessionChk.do")	// mypage로 이동 전 세션 체크 by선희
	public String mypageSessionChk(Model model, HttpSession session) {
		int result = 0;
		if (session.getAttribute("email") != null) {
			String email = (String) session.getAttribute("email");
			result = 1;
			model.addAttribute("email", email);
		} else {
			result = -1;	// 로그인 안한 경우
		}
		model.addAttribute("result", result);
		return "account/mypageSessionChk";
	}
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

	@RequestMapping("/account/wishList.do") //마이페이지-위시리스트 by 수인
	public String wishList(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		List<Wish> wishList = ws.wishList(email);
		model.addAttribute("wishList",wishList);
		return "account/wishList";
	}
	@RequestMapping("/account/cartList.do") //마이페이지 - 장바구니리스트 by 수인
	public String cartList(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		List <Cart> cartList = cs.cartList(email);
		model.addAttribute("cartList",cartList);
		return "account/cartList";
	}
	
	@RequestMapping("/account/addCart.do") //장바구니 추가 by 수인
	public String addCart(HttpSession session, ProductDetail productDetail, Model model) {
		int result = 0;
		if(session.getAttribute("email")== null) { //로그인x - 이메일로그인창 
			result = -1;
		} else { //로그인o - 장바구니 추가			
			String email = (String) session.getAttribute("email");
			int productDetailNo = productDetail.getProductDetailNo();
			Cart cart = new Cart();
			cart.setEmail(email);
			cart.setProductDetailNo(productDetailNo);
			
			Cart cart2 = cs.select(cart);
			
			if(cart2 == null) { //장바구니에 해당상품 없으면 추가(재고는 1로)
				result = cs.insert(cart); 
			} else { // 카트에 이미 상품 있으면 - 재고+1
				result = cs.update(cart2);
			}

		}
		model.addAttribute("result", result);
		return "account/addCart";
	}
	
	@RequestMapping("/account/deleteCart.do") // 장바구니 - 삭제 by 수인
	public String deleteCart(HttpSession session, int cartNo, Model model) {
		int result = 0;
		if(session.getAttribute("email") == null) { //로그인x
			result = -1; 
		} else { //로그인o - 장바구니 삭제
			result = cs.deleteCart(cartNo);
		}
		model.addAttribute("result",result);
		return "account/deleteCart";
	}
	
	@RequestMapping("/account/orderList.do")		// 로그인한 회원의 주문내역 불러오기 by선희
	public String orders(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<UserOrder> userOrders = uos.selectUserOrder(email);
		List<UserOrder> userOrderDetails = new ArrayList<>();
		List<UserOrder> orderInfo = new ArrayList<>();
		List<Integer> orderCnt = new ArrayList<>();
		for (UserOrder userOrder:userOrders) {
			if (userOrder != null) {
				// userOrderDetails = uos.selectUserOrderDetail(userOrder.getOrderNo());
				userOrderDetails = uos.selectOrderDetail(userOrder.getOrderNo());
				// 주문번호당 상품 주문 개수
				 uos.orderCnt(userOrder.getOrderNo());
				System.out.println("orderCnt"+orderCnt);
				System.out.println("ffffffffffffffff"+userOrder.getOrderNo());
				System.out.println(userOrderDetails.size());
				
				orderCnt.add(userOrderDetails.size());
				orderInfo.addAll(userOrderDetails);
				/*
				 * for(UserOrder order:userOrderDetails) { orderInfo =
				 * uos.orderInfoAll(order.getOrderDetailNo()); }
				 */
					
				
				//list.add(orderDetail);
				
			}
		}
		model.addAttribute("userOrderDetails", userOrderDetails);
		model.addAttribute("userOrders", userOrders);
		model.addAttribute("orderCnt", orderCnt);
		model.addAttribute("orderInfo", orderInfo);
		return "account/orderList";
	}
	@RequestMapping("/account/orderDetail.do") 	// 로그인한 회원의 주문내역 상세 불러오기 by선희
	public String orderDetail(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<UserOrder> userOrder = uos.selectUserOrder(email);
		List<UserOrder> list = new ArrayList<>();
		UserOrder orderDetail = null;
		for (UserOrder user:userOrder) {
			if (user != null) {
				
				//orderDetail = uos.selectOrderDetail(user.getOrderNo());
				
				list.add(orderDetail);
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("userOrder", userOrder);
		return "account/orderDetail";
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
	@RequestMapping("/account/reviewList.do")		// 마이페이지 - 리뷰리스트 불러오기 by선희
	public String reviewList(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<Review> rvList = rvs.memberReview(email);
		List<ProductPhoto> photos = new ArrayList<>();
		ProductPhoto photo = null;
		for (Review rv:rvList) {
			photo = pps.getPhoto(rv.getProductNo(), rv.getColor());
			photos.add(photo);
		}
		model.addAttribute("rvList", rvList);
		model.addAttribute("photos", photos);
		return "account/reviewList";
	}
	@RequestMapping("/account/address.do")	// 배송지관리로 이동 by선희
	public String address(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<Address> addrList = as.selectAddr(email);
		model.addAttribute("addrList", addrList);
		return "account/address";
	}
	@RequestMapping("/account/addAddr.do")	//  by선희
	public String addAddr(Model model, HttpSession session) {
		
		return "account/addAddr";
	}
	
}
