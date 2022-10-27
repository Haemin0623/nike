package com.ch.nike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Member;
import com.ch.nike.service.MemberService;

@Controller
public class MemberController {
	@Autowired 
	private MemberService ms;
	
	@RequestMapping("/member/emailLogin.do")
	public String emailLogin(String email, Model model) {
		
		Member member = ms.select(email);
			if (member != null) { // 가입되어있을때
				return "/member/pwLoginForm";
			} else {//가입안되어있을때
				return "/member/joinForm";
			}
		
	}
	
}
