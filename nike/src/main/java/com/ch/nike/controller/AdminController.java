package com.ch.nike.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.dto.UserOrderDetail;
import com.ch.nike.service.AdminService;
import com.ch.nike.service.MemberService;
import com.ch.nike.service.NoticeService;
import com.ch.nike.service.ProductDetailService;
import com.ch.nike.service.ProductPhotoService;
import com.ch.nike.service.ProductService;
import com.ch.nike.service.QnAService;
import com.ch.nike.service.ReviewService;
import com.ch.nike.service.StoreService;
import com.ch.nike.service.UserOrderDetailService;
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
	private ProductPhotoService pps;
	@Autowired
	private ProductDetailService pds;
	@Autowired
	private UserOrderDetailService uods;
	
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
		
		model.addAttribute("num", num);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminMemberList";
	} 
	@RequestMapping("/adminMemberDetail.do")// 관리자 멤버상세 
	public String adminMemberDetail(String email, Model model) {
		Member member = ms.select(email);
		List<Review> review = rs.reviewselect(email);
		//List<Wish> wish = ws.wishselect(email);
		List<UserOrder> userorder = uos.userorderselect(email);
		model.addAttribute("member",member);
		model.addAttribute("review",review);
		//model.addAttribute("wish",wish);
		model.addAttribute("userorder",userorder);
		return "admin/adminMemberDetail";
	}
	

	@RequestMapping("/adminProductList.do")// 관리자 상품 리스트 by창률 
	public String adminProductList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = ps.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<Product> list2 = ps.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);

		//List<Product> list = ps.adminproductlist();
		model.addAttribute("num", num);
		//model.addAttribute("list", list);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminProductList";
	}

	
	@RequestMapping("/adminProductInsert.do")// 관리자 상품 수정 
	public String adminProductInsert() {
		return "admin/adminProductInsert";
	}
	
	@RequestMapping("/adminProductUpdate.do")// 관리자 상품 업데이트 
	public String adminProductUpdate(int productDetailNo,Model model) {
		Product product = ps.select(productDetailNo);
		model.addAttribute("productDetailNo",productDetailNo);
		model.addAttribute("product",product);
		return "admin/adminProductUpdate";
	}
	
	@RequestMapping("/adminOrderList.do")// 관리자 주문 리스트 by창률 
	public String adminOrderList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = uos.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<UserOrder> list2 = uos.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("num", num);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminOrderList";
	}
	
	@RequestMapping("/adminQnaList.do")// 관리자 문의 리스트 by창률 
	public String adminQnaList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = qs.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<UserOrder> list2 = qs.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("num", num);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminQnaList";
	}
	
	@RequestMapping("/adminQnaDetail.do")// 관리자 문의 상세 
	public String adminQnaDetail() {
		return "admin/adminQnaDetail";
	}
	
	@RequestMapping("/adminReviewList.do") // 관리자 리뷰 리스트 by창률 
	public String adminReviewList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = rs.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<UserOrder> list2 = rs.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("num", num);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminReviewList";
	}
	
	@RequestMapping("/adminNoticeList.do") //공지 리스트 by창률
	public String adminNoticeList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = ns.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<UserOrder> list2 = ns.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("num", num);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
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
	public String adminStoreList(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = ss.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<UserOrder> list2 = ss.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("num", num);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminStoreList";
	}
	@RequestMapping("/adminStoreInsert.do") //관리자 매장 등록
	public String adminStoreInsert() {
		return "admin/adminStoreInsert";
	}
	
	@RequestMapping("/adminProductInsertResult.do")
	public String adminProductInsert(Product product, Model model, ProductPhoto productPhoto, MultipartHttpServletRequest mhr) throws IOException {
		int result = 0;
		int productNo = 0;
		productNo = ps.selectproductNo();
		product.setProductNo(productNo);
		
		String fileName = mhr.getFile("file").getOriginalFilename();
		product.setProductPhoto(fileName);
		String real = "src/main/resources/static/images/product_photo";
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
		fos.write(mhr.getFile("file").getBytes());
		fos.close();
		result = ps.productinsert(product);
		result = pps.productinsert(product);
		List<MultipartFile> list = mhr.getFiles("file2");
		
		// list의 사진을 하나씩 뽑아서 photos에 저장
		for(MultipartFile mf : list) {
			ProductPhoto pp = new ProductPhoto();
			String fileName2 = mf.getOriginalFilename();
			pp.setProductPhoto(fileName2);
			
			// 그림파일 저장
			FileOutputStream fos2 = new FileOutputStream(new File(real+"/"+fileName2));
			fos2.write(mf.getBytes());
			fos2.close();
			product.setProductPhoto(fileName2);
			result = pps.productinsert2(product);
		}
		
		result = pds.productinsert(product);
		model.addAttribute("result",result);
		return "admin/adminProductInsertResult";
	}
	
	@RequestMapping("/adminProductUpdateResult.do")
	public String adminProductUpdateResult(Product product, Model model, ProductPhoto productPhoto, MultipartHttpServletRequest mhr) throws IOException {
		int result =0;
		int productPhotoNo =0;
		productPhotoNo = pps.selectproductPhotoNo(product);
		product.setProductPhotoNo(productPhotoNo);
		
		result = pps.productdelete(product);
		
		String fileName = mhr.getFile("file").getOriginalFilename();
		product.setProductPhoto(fileName);
		String real = "src/main/resources/static/images/product_photo";
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
		fos.write(mhr.getFile("file").getBytes());
		fos.close();
		result = ps.productupdate(product);
		result = pps.productinsert(product);
		List<MultipartFile> list = mhr.getFiles("file2");
		// list의 사진을 하나씩 뽑아서 photos에 저장
		for(MultipartFile mf : list) {
			ProductPhoto pp = new ProductPhoto();
			String fileName2 = mf.getOriginalFilename();
			pp.setProductPhoto(fileName2);
			
			// 그림파일 저장
			FileOutputStream fos2 = new FileOutputStream(new File(real+"/"+fileName2));
			fos2.write(mf.getBytes());
			fos2.close();
			product.setProductPhoto(fileName2);
			result = pps.productinsert2(product);
			
		}
		result = pds.productupdate(product);
		model.addAttribute("result",result);
	return "admin/adminProductUpdateResult";
	}
	
	@RequestMapping("/adminOrderDetail.do")
	public String adminOrderDetail(String pageNum, Model model, PagingBean pagingbean) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = uods.getTotal();		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		pagingbean.setStartRow(startRow);
		pagingbean.setEndRow(endRow);
		List<UserOrderDetail> list2 = uods.paginglist(pagingbean);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("num", num);
		model.addAttribute("list2",list2);
		model.addAttribute("pb", pb);
		return "admin/adminOrderDetail";
	}
}
