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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.nike.dto.Review;
import com.ch.nike.dto.ReviewPhoto;
import com.ch.nike.service.ReviewPhotoService;
import com.ch.nike.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService rs;
	@Autowired
	private ReviewPhotoService rps;
	
	@RequestMapping("/product/reviewWriteFormChk.do")
	public String reviewWriteFormChk(int productNo, String color, Model model, HttpSession session) {
		int result = 0;
		if (session.getAttribute("email") != null) {
			result = 1;
		} else {
			result = -1;
		}
		model.addAttribute("productNo", productNo);
		model.addAttribute("color", color);
		model.addAttribute("result", result);
		return "product/reviewWriteFormChk";
	}
	@RequestMapping("/product/reviewWriteForm.do")
	public String reviewWriteForm(int productNo, String color, Model model, HttpSession session) {
		model.addAttribute("color", color);
		model.addAttribute("productNo", productNo);
		return "product/reviewWriteForm";
	}
	@RequestMapping("/product/reviewWrite.do")
	public String writeReviewForm(Review review, int productNo, String color, Model model, HttpSession session, 
			MultipartHttpServletRequest mhr) throws IOException {
		int result = 0;
		String email = (String) session.getAttribute("email");
		Review review2 = rs.productReview(email, productNo);
		if (review2 == null) {
			// 한번에 여러개의 파일이 들어온다
			List<MultipartFile> list = mhr.getFiles("file");
			String real = "src/main/resources/static/images/review_photo";
			// list의 사진을 하나씩 뽑아서 photos에 저장
			Review rv = new Review();
			int reviewNo = rs.countReview();
			review.setReviewNo(reviewNo);
			review.setProductNo(productNo);
			review.setEmail(email);
			rs.insert(review);
			
			for(MultipartFile mf : list) {
				ReviewPhoto rp = new ReviewPhoto();
				String reviewPhoto = mf.getOriginalFilename();
				rp.setReviewPhoto(reviewPhoto);
				rp.setReviewNo(reviewNo);
				int reviewPhotoNo = rps.countReviewPhoto();
				rp.setReviewPhotoNo(reviewPhotoNo);
				
				// 그림파일 저장
				FileOutputStream fos = new FileOutputStream(new File(real+"/"+reviewPhoto));
				fos.write(mf.getBytes());
				fos.close();
				
				result = rps.insert(rp);
				
			}
		} else {
			result = -1;
		}
		model.addAttribute("color", color);
		model.addAttribute("productNo", productNo);
		model.addAttribute("result", result);
		return "product/reviewWrite";
	}
}
