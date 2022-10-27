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

	@RequestMapping("/member/emailLoginForm.do")
	public String emailLoginForm() {
		return "member/emailLoginForm";
	}

	@RequestMapping("/member/emailLogin.do")
	public String emailLogin(Member member, Model model) {
		Member member2 = ms.select(member.getEmail());
		if (member2 != null) { // 가입되어있을때
			return "member/pwLoginForm";
		} else {// 가입안되어있을때
			return "member/joinForm";
		}

	}

}
