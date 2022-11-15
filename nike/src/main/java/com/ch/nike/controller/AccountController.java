package com.ch.nike.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.nike.dto.Address;
import com.ch.nike.dto.Cart;
import com.ch.nike.dto.Member;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.Refund;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.Wish;
import com.ch.nike.service.AddressService;
import com.ch.nike.service.CartService;
import com.ch.nike.service.MemberService;
import com.ch.nike.service.ProductDetailService;
import com.ch.nike.service.ProductPhotoService;
import com.ch.nike.service.ProductService;
import com.ch.nike.service.QnAService;
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
	@Autowired
	private QnAService qs;
	@Autowired 
	private BCryptPasswordEncoder bpe; //비번 암호화
	@Autowired
	private ProductDetailService pds;
	
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
	
	@RequestMapping("/account/profileUpdate.do") //마이페이지 - 프로필 - 수정 by수인
	public String profileUpdate(HttpSession session, Member member, String tel1, String tel2, String tel3, Model model ) {
		int result = 0;
		member.setMemberTel(tel1+"-"+tel2+"-"+tel3);
		result = ms.updateProfile(member); // 담아온 값을 넣어서 수정
		model.addAttribute("result", result);
		return "account/profileUpdate";
	}
	@RequestMapping("/account/pwUpdateProfileForm.do") //마이페이지 - 프로필 - 비밀번호 수정 by수인
	public String pwUpdateProfileForm() {	
		return "account/pwUpdateProfileForm";
	}

	@RequestMapping("/account/pwUpdateProfile.do")
	public String pwUpdateProfile(HttpSession session, String password, String newPw1, String newPw2, Model model) {
		int result = 0;
		String email = (String) session.getAttribute("email");
		Member member = ms.select(email);
		if (bpe.matches(password, member.getPassword())) { // member의 비번(암호화된것 풀고) = 입력한 현재비번과 일치하면
			if (newPw1.equals(newPw2)) {
				member.setPassword(bpe.encode(newPw1)); //암호화해서 넣어준다
				result = ms.changePw(member);
			} else
				result = -1; //비번=비번확인일치하지 않습니다 - 다시입력창
		}else
			result = -2; //member비번과 입력한 비번 일치하지 않으면 현재 비번을 다시입력해주세요
		System.out.println("");
		model.addAttribute("result",result);
		return "account/pwUpdateProfile";
	}
	
	@RequestMapping("/account/deleteMember.do")	// mypage - profile에서 회원탈퇴 by선희
	public String deleteMember(String email, Model model, HttpSession session) {
		int result = ms.deleteMember(email);
		model.addAttribute("result", result);
		session.invalidate();
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
		int totalPrice = 0;
		for(Cart cart:cartList) {
			totalPrice += (cart.getPrice()*cart.getCartQuantity());
		}
		model.addAttribute("cartList",cartList);
		model.addAttribute("totalPrice", totalPrice);
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
		UserOrder userOrderDetails = null;
		List<UserOrder> orderInfo = new ArrayList<>();
		List<UserOrder> orderDate = new ArrayList<>();
		for (UserOrder userOrder:userOrders) {
			orderDate = uos.selectDate(email);
			if (userOrder != null) {
				userOrderDetails = uos.orderInfoAll(userOrder.getOrderDetailNo());
				orderInfo.add(userOrderDetails);
			}
		}
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("orderDate", orderDate);
		return "account/orderList";
	}
	@RequestMapping("/account/orderDetail.do") 	// 로그인한 회원의 주문내역 상세 불러오기 by선희
	public String orderDetail(int orderNo, Model model, HttpSession session) {
		Address address = as.getAddr(orderNo);
		List<UserOrder> orderDetails = uos.selectOrderDetail(orderNo);
		model.addAttribute("address", address);
		model.addAttribute("orderDetails", orderDetails);
		return "account/orderDetail";
	}
	@RequestMapping("/account/refundForm.do")		// 주문내역 - 환불신청으로 넘어가기 by선희
	public String refundForm(int orderDetailNo, Model model, HttpSession session) {
		Refund productInfo = rs.selectPro(orderDetailNo);
		model.addAttribute("productInfo", productInfo);
		return "account/refundForm";
	}
	@RequestMapping("/account/refund.do")	// 환불신청하기 by선희
	public String refund(Refund refund, int orderNo, Model model, HttpSession session
			) throws IOException {
		int result = 0;
		
		String refundPhoto = refund.getFile().getOriginalFilename();
		refund.setRefundPhoto(refundPhoto);
		
		String real = "src/main/resources/static/images/refund_photo";
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+refundPhoto));
		fos.write(refund.getFile().getBytes());
		fos.close();
		
		int refundNum = rs.selectRefundNum();
		refund.setRefundNo(refundNum);
		
		rs.insertRefund(refund);
		rs.updateRefundChk(refund.getOrderDetailNo());
		result = 1;
		
		model.addAttribute("result", result);
		model.addAttribute("orderNo", refund.getOrderNo());
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
		model.addAttribute("email",email);
		return "account/address";
	}
	@RequestMapping("/account/qnaList.do")	// 문의 내역 불러오기 by 선희
	public String qnaList(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<QnA> qnaList = qs.qnaListByEmail(email);
		model.addAttribute("qnaList", qnaList);
		return "account/qnaList";
	}
	
	@RequestMapping("/account/deleteQna.do")	// 문의 내역 삭제하기 by 선희
	public String deleteQna(int qnaNo, Model model, HttpSession session) {
		int result = qs.deleteQna(qnaNo);
		model.addAttribute("result", result);
		return "account/deleteQna";
	}
<<<<<<< HEAD
	@RequestMapping("/account/addAddrForm.do")//  by창률 배송지 추가 페이지
	public String addAddrForm(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email",email);
		return "account/addAddrForm";
	}
	@RequestMapping("/account/addAddr.do")	//  by창률 배송지 추가
	public String addAddr(Model model,Address address, HttpSession session) {
		int result = 0;
		result = as.insertaddress(address);
		List<Address> addrList = as.selectAddr(address.getEmail());
		model.addAttribute("addrList", addrList);
		return "redirect:/account/address.do";
	}
	@RequestMapping("/account/addrDelete.do")
	public String addrDelete(Model model,int addrNo) {
		int result = 0;
		result = as.Deleteaddr(addrNo);
		return "redirect:/account/address.do";
	}

	
	@RequestMapping("/account/changeSize.do")	// cartList에서 사이즈 변경 by 선희
	public String changeSize(int cartNo, ProductDetail productDetail, Model model, HttpSession session) {
		int productDetailNo = pds.getProductDetailNo(productDetail);
		Cart cart = cs.selectBy(cartNo);
		cart.setProductDetailNo(productDetailNo);
		cs.updateSize(cart);
		return "redirect:/account/cartList.do";
	}
	@RequestMapping("/account/changeQuantity.do")	// cartList에서 수량 변경 by 선희
	public String changeQuantity(int quantity, int cartNo, Model model, HttpSession session) {
		Cart cart = cs.selectBy(cartNo);
		cart.setCartQuantity(quantity);
		cs.updateQuantity(cart);
		return "redirect:/account/cartList.do";
	}
	

}
