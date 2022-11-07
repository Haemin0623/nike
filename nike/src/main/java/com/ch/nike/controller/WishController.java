package com.ch.nike.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Wish;
import com.ch.nike.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService ws;
	@RequestMapping("/product/addWish.do")	// 위시리스트 추가 및 삭제 by선희
	public String addWish(int productNo, Model model, HttpSession session) {
		int result = 0;
		if (session.getAttribute("email") != null) {
			String email = (String) session.getAttribute("email");
			Wish wish = ws.selectWishResult(email, productNo);
			if (wish != null) {	// 있으면 삭제
				ws.deleteWish(email, productNo);
				result = 1;
			} else {				// 없으면 추가
				int wishNo = ws.selectCount();
				ws.addWish(email, productNo, wishNo);
				result = 2;
			}
		} else {
			result = -1;	// 로그인 안한 경우
		}
		model.addAttribute("result", result);
		return "product/addWish";
	}
}
