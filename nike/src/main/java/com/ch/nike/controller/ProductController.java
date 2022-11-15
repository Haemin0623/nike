package com.ch.nike.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Filter;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductDetail;
import com.ch.nike.dto.ProductFeature;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Review;
import com.ch.nike.dto.ReviewPhoto;
import com.ch.nike.service.ProductDetailService;
import com.ch.nike.service.ProductFeatureService;
import com.ch.nike.service.ProductPhotoService;
import com.ch.nike.service.ProductService;
import com.ch.nike.service.ReviewPhotoService;
import com.ch.nike.service.ReviewService;

import groovyjarjarantlr4.v4.misc.EscapeSequenceParsing.Result;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	@Autowired
	private ProductPhotoService pps;
	@Autowired
	private ProductDetailService pds;
	@Autowired
	private ProductFeatureService pfs;
	@Autowired
	private ReviewService rs;
	@Autowired
	private ReviewPhotoService rps;
	
	
	@RequestMapping("/") //메인 최하단 하단 신발 리스트 by창률 // 로그아웃 위한 세션작업 by수인
	public String main(Model model, HttpSession session) {
		return "nike_main";
	}
	
	
	@RequestMapping("/product/newReleases.do")
	public String newReleases(Filter filter, String pageNum, Model model) {
		int result = 0;
		// 페이징
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		
		int total = 0;
		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		// int num = total - startRow + 1;
		filter.setStartRow(startRow);
		filter.setEndRow(endRow);
		
		
		
		if (filter.getGender() != null || filter.getColor() != null || filter.getPrice() != null || filter.getProductSize() != null) {
			total = ps.getTotal2(filter);	// 예스필터
			PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
			// List<Product> filterList = ps.filterList(filter);
			List<Product> filterList = ps.filterListPaging(filter);
			model.addAttribute("filterList", filterList);
			model.addAttribute("pb", pb);
			result = 1;
		} else {
			total = ps.getTotal1(filter);	// 노필터
			PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
			// List<Product> productList = ps.list();
			List<Product> productList = ps.listPaging(filter);
			model.addAttribute("productList", productList);
			model.addAttribute("pb", pb);
			result = 2;
		}
		model.addAttribute("total", total);
		model.addAttribute("result", result);
		return "product/newReleases";
	}
	
	@RequestMapping("/product/productDetail.do") //해당상품의 상세정보 by수인
	public String productDetail(int productNo, String color, Model model) {
		Product product = ps.selectsoo(productNo);
		Product category = ps.productCategory(productNo);
		product.setColor(color);
		List<ProductDetail> productDetailList  = pds.detailList(productNo);
		List<ProductPhoto> productPhotoList = pps.photoList(product);
		List<ProductFeature> productFeatureList = pfs.featureList(productNo);
		List<ProductPhoto> thumPhotoList = pps.thumPhotoList(productNo);
		List<Product> productRecommendList = ps.recommendList();
		
		
		model.addAttribute("productFeatureList",productFeatureList);
		
		//리뷰리스트
		List<Review> rvList = rs.selectProductReview(productNo);
		List<ReviewPhoto> rvPhotos = new ArrayList<>();	
		List<ReviewPhoto> rvPhotos2 = new ArrayList<>();
		for (Review rv:rvList) {
			rvPhotos = rps.selectReviewPhoto(rv.getReviewNo());
			rvPhotos2.addAll(rvPhotos);
		}
		
		model.addAttribute("product", product);
		model.addAttribute("productDetailList",productDetailList);
		model.addAttribute("productPhotoList",productPhotoList);
		model.addAttribute("thumPhotoList",thumPhotoList);
		model.addAttribute("productRecommendList", productRecommendList);
		model.addAttribute("color", color);
		model.addAttribute("category", category);
		
		model.addAttribute("rvPhotos", rvPhotos2);
		model.addAttribute("rvList", rvList);
		model.addAttribute("productNo", productNo);

		return "product/productDetail";
	}
}
