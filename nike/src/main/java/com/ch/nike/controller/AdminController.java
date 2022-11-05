package com.ch.nike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.Notice;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.Wish;
import com.ch.nike.service.AdminService;
import com.ch.nike.service.MemberService;
import com.ch.nike.service.NoticeService;
import com.ch.nike.service.ProductService;
import com.ch.nike.service.QnAService;
import com.ch.nike.service.ReviewService;
import com.ch.nike.service.StoreService;
import com.ch.nike.service.UserOrderService;
import com.ch.nike.service.WishService;

@Controller
public class AdminController {
	@Autowired
	private AdminService as;
	@Autowired
	private MemberService ms;
	@Autowired
	private ReviewService rs;
	@Autowired
	private StoreService ss;
	@Autowired
	private ProductService ps;
	@Autowired
	private WishService ws;
	@Autowired
	private UserOrderService uos;
	@Autowired
	private NoticeService ns;
	@Autowired
	private QnAService qs;
	@Autowired
	
	@RequestMapping("/adminMain.do")// 관리자 메인으로 이동
	public String adminMain() {
		return "admin/adminMain";
	}
	
	@RequestMapping("/adminMemberList.do")// 관리자 멤버리스트 by창률 
	public String adminMemberList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = ms.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow); 
		pagingbean.setEndRow(endRow);
		List<Member> list2 = ms.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		List<Member> list = ms.memberlist();
		
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminMemberList";
	} 
	@RequestMapping("/adminMemberDetail.do")// 관리자 멤버상세 
	public String adminMemberDetail(String email, Model model) {
		Member member = ms.select(email);
		List<Review> review = rs.reviewselect(email);
		List<Wish> wish = ws.wishselect(email);
		List<UserOrder> userorder = uos.userorderselect(email);
		model.addAttribute("member",member);
		model.addAttribute("review",review);
		model.addAttribute("wish",wish);
		model.addAttribute("userorder",userorder);
		return "admin/adminMemberDetail";
	}
	
	@RequestMapping("/adminProductList.do")// 관리자 상품 리스트 by창률 
	public String adminProductList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = ms.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<Product> list2 = ps.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		List<Product> list = ps.adminproductlist();
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
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
		List<UserOrder> list = uos.orderlist();
		model.addAttribute("list",list);
		return "admin/adminOrderList";
	}
	
	@RequestMapping("/adminQnaList.do")// 관리자 문의 리스트 by창률 
	public String adminQnaList(Model model) {
		List<QnA> list = qs.qnalist();
		model.addAttribute("list",list);
		return "admin/adminQnaList";
	}
	
	@RequestMapping("/adminQnaDetail.do")// 관리자 문의 상세 
	public String adminQnaDetail() {
		return "admin/adminQnaDetail";
	}
	
	@RequestMapping("/adminReviewList.do") // 관리자 리뷰 리스트 by창률 
	public String adminReviewList(Model model) {
		List<Review> list = rs.reviewlist();
		model.addAttribute("list",list);
		return "admin/adminReviewList";
	}
	
	@RequestMapping("/adminNoticeList.do") //공지 리스트 by창률
	public String adminNoticeList(Model model) {
		List<Notice> list = ns.noticelist();
		model.addAttribute("list",list);
		return "admin/adminNoticeList";
	}
	
	@RequestMapping("/adminNoticeDetail.do") //관리자 공지 상세 
	public String adminNoticeDetail() {
		return "admin/adminNoticeDetail";
	}
	
	@RequestMapping("/adminNoticeInsert.do") //관리자 공지 등록
	public String adminNoticeInsert() {
		return "admin/adminNoticeInsert";
	}
	@RequestMapping("/adminStoreList.do")	//관리자 매장 관리 by창률
	public String adminStoreList(Model model) {
		List<Store> list = ss.storelist();
		model.addAttribute("list",list);
		return "admin/adminStoreList";
	}
	@RequestMapping("/adminStoreInsert.do") //관리자 매장 등록
	public String adminStoreInsert() {
		return "admin/adminStoreInsert";
	}
}
