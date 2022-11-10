package com.ch.nike.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ch.nike.dto.Wish;
import com.ch.nike.service.CartService;
import com.ch.nike.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService ws;
	
	@RequestMapping("/product/addWish.do")
	public String addWish(HttpSession session, Wish wish, Model model, Integer page) { //int는 null을 받을수없음
		int result = 0;
		if (session.getAttribute("email") == null) { // 로그인x- 이메일로그인창
			result = -2;
		} else { //로그인o - 위시리스트 추가/삭제
			String email = (String) session.getAttribute("email");
			wish.setEmail(email);
			Wish wish2 = ws.selectByEmail(wish); // productNo, email, color

			if (wish2 == null) { // 없으면 추가(1)
				result = ws.insert(wish);
			} else { // 있을때- 다시누르면 위시리스트에서 삭제
				ws.delete(wish2.getWishNo());
				result = -1;
			}
		}
		if(page != null) {
			result = page;
		}
		model.addAttribute("result", result);
		return "product/addWish";
	}

}
