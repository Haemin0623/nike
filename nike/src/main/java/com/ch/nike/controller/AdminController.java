package com.ch.nike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService as;
	
	@RequestMapping("/adminMain.do")// 관리자 메인으로 이동
	public String adminMain() {
		return "admin/adminMain";
	}
	
	@RequestMapping("/adminMemberList.do")// 관리자 멤버리스트 by창률 
	public String adminMemberList(Model model) {
		List<Member> list = as.memberlist();
		model.addAttribute("list",list);
		return "admin/adminMemberList";
	}
	@RequestMapping("/adminMemberDetail.do")// 관리자 멤버상세 
	public String adminMemberDetail() {
		return "admin/adminMemberDetail";
	}
	
	@RequestMapping("/adminProductList.do")// 관리자 상품 리스트 by창률 
	public String adminProductList(Model model) {
		List<Product> list = as.productlist();
		model.addAttribute("list",list);
		return "admin/adminProductList";
	}
	
	@RequestMapping("/adminProductInsert.do")// 관리자 상품 수정 
	public String adminProductInsert() {
		return "admin/adminProductInsert";
	}
	
	@RequestMapping("/adminProductUpdate.do")// 관리자 상품 업데이트 
	public String adminProductUpdate() {
		return "admin/adminProductUpdate";
	}
	
	@RequestMapping("/adminOrderList.do")// 관리자 주문 리스트 by창률 
	public String adminOrderList(Model model) {
		List<UserOrder> list = as.orderlist();
		model.addAttribute("list",list);
		return "admin/adminOrderList";
	}
	
	@RequestMapping("/adminQnaList.do")// 관리자 문의 리스트 by창률 
	public String adminQnaList(Model model) {
		List<QnA> list = as.qnalist();
		model.addAttribute("list",list);
		return "admin/adminQnaList";
	}
	
	@RequestMapping("/adminQnaDetail.do")// 관리자 문의 상세 
	public String adminQnaDetail() {
		return "admin/adminQnaDetail";
	}
	
	@RequestMapping("/adminReviewList.do") // 관리자 리뷰 리스트 by창률 
	public String adminReviewList(Model model) {
		List<Review> list = as.reviewlist();
		model.addAttribute("list",list);
		return "admin/adminReviewList";
	}
}
